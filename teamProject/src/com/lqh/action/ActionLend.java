package com.lqh.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.lqh.Dao.BookDao;
import com.lqh.Dao.LendDao;
import com.lqh.Dao.StudentDao;
import com.lqh.model.Book;
import com.lqh.model.Lend;
import com.lqh.model.Pager;
import com.lqh.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionLend extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int pageNow = 1;                                    
	private int pageSize = 8;
	private Lend lend;
	private String message;
	
	LendDao lendDao = new LendDao();
	
	//查看所借书籍；
	public String selectAllLend(){ 		
//		System.out.println(lend);
		if(lend.getReaderId() == null || lend.getReaderId().equals("")){
			this.setMessage("请输入借书证号！");
			System.out.println("ActionLend.selectAllLend() 第一个判断为空");
			return "success";
		}else if(new StudentDao().selectByReaderId(lend.getReaderId()) == null){
			this.setMessage("不存在该学生");
			System.out.println("ActionLend.selectAllLend() 第二个判断为空");
			return "success";
		}
		List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
		System.out.println("pageNow : " + pageNow);
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		ActionContext request = (ActionContext)ActionContext.getContext();
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		return "success";
	}
	

	@SuppressWarnings("unchecked")
	public String lendBook() throws Exception{  
		BookDao bookDao = new BookDao();
		Book book = bookDao.bookSelect(lend.getISBN());
		
		if(lend.getISBN() == null || lend.getISBN().equals("")){
			setMessage("ISBN不能为空！");
			return "success";
		}else if(book == null){
			setMessage("不存在该书！");
			return "success";
		}else if(book.getSnum() == 0){
			List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			request.put("ISBN", lend.getISBN());
			setMessage("抱歉，该书当前库存量为0");
			return "success";
		}
		String currentId = (lendDao.selectMaxId() + 1) + "";											//得到当前最大bookId;
		Date currentTime = new Date(System.currentTimeMillis());            //得到当前时间
		lend.setBookId(currentId);
		lend.setLendTime(currentTime);
		try{
			lendDao.addLend(lend);										//修改借书表；
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("更新借书表失败!");
		}
		book.setSnum(book.getSnum() - 1);
		bookDao.updateBook(book);                                   //修改book的库存量
		StudentDao stuDao = new StudentDao();
		Student student = stuDao.selectByReaderId(lend.getReaderId());
		student.setNum(student.getNum() + 1);
		stuDao.updateStudent(student);								//修改学生的借书量；
		List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.pageNow, this.pageSize);
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());				//最后显示借书情况；
		request.put("ISBN", lend.getISBN());
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String returnBook() throws Exception{  
		BookDao bookDao = new BookDao();
		Book book = bookDao.bookSelect(lend.getISBN());
		
		if(lend.getISBN() == null || lend.getISBN().equals("")){
			setMessage("ISBN不能为空！");
			return "success";
		}else if(book == null){
			setMessage("不存在该书！");
			return "success";
		}else if(book.getSnum() == book.getCnum()){
			List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			request.put("ISBN", lend.getISBN());
			setMessage("抱歉，该书未被借出");
			return "success";
		}
		String currentId = lendDao.selectMinIdFromISBN(lend) + "";		//得到当前isbn最小bookId(既是最早借出去的);
		lend.setBookId(currentId);
		try{
			lendDao.dropLend(lend);										//修改借书表；
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("更新借书表失败!");
		}
		book.setSnum(book.getSnum() + 1);
		bookDao.updateBook(book);                                   //修改book的库存量
		StudentDao stuDao = new StudentDao();
		Student student = stuDao.selectByReaderId(lend.getReaderId());
		student.setNum(student.getNum() - 1);
		stuDao.updateStudent(student);								//修改学生的借书量；
		List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.pageNow, this.pageSize);
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());				//最后显示借书情况；
		request.put("ISBN", lend.getISBN());
		return "success";
	}
	
	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Lend getLend() {
		return lend;
	}
	public void setLend(Lend lend) {
		this.lend = lend;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
