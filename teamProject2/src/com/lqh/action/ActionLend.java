package com.lqh.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.lqh.Dao.BookDao;
import com.lqh.Dao.LendDao;
import com.lqh.Dao.StudentDao;
import com.lqh.Dao.impl.BookDaoImpl;
import com.lqh.Dao.impl.LendDaoImpl;
import com.lqh.Dao.impl.StudentDaoImpl;
import com.lqh.tool.Pager;
import com.lqh.vo.Book;
import com.lqh.vo.Lend;
import com.lqh.vo.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionLend extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int pageNow = 1;                                    
	private int pageSize = 8;
	private Lend lend;
	private String message;
	
	LendDao lendDao = new LendDaoImpl();
	
	//查看所借书籍；
	public String selectAllLend(){ 		
//		System.out.println(lend);
		if(lend.getReaderId() == null || lend.getReaderId().equals("")){
			this.setMessage("请输入借书证号！");
			System.out.println("ActionLend.selectAllLend() 第一个判断为空");
			return "success";
		}else if(new StudentDaoImpl().selectStudent(lend.getReaderId()) == null){
			this.setMessage("不存在该学生");
			System.out.println("ActionLend.selectAllLend() 第二个判断为空");
			return "success";
		}
		List<?> list = lendDao.selectBook(lend.getReaderId(), this.getPageNow(), this.getPageSize());
		System.out.println("pageNow : " + pageNow);
		Pager page = new Pager(pageNow,lendDao.selectBookSize(lend.getReaderId()));
		ActionContext request = (ActionContext)ActionContext.getContext();
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		return "success";
	}
	

	@SuppressWarnings("unchecked")
	public String lendBook() throws Exception{  
		BookDao bookDao = new BookDaoImpl();
		Book book = bookDao.selectBook(lend.getISBN());
		
		if(lend.getISBN() == null || lend.getISBN().equals("")){
			setMessage("ISBN不能为空！");
			return "success";
		}else if(book == null){
			setMessage("不存在该书！");
			return "success";
		}else if(book.getSnum() == 0){
			List<?> list = lendDao.selectBook(lend.getReaderId(), this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow,lendDao.selectBookSize(lend.getReaderId()));
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			request.put("ISBN", lend.getISBN());
			setMessage("抱歉，该书当前库存量为0");
			return "success";
		}
		
		Lend l = new Lend(this.lend.getReaderId(), this.lend.getISBN(), new Date(System.currentTimeMillis()));
		System.out.println("lTime在这里~~~~~~~~~~~~~~~~~~~~~~~~~~~" + l.getLtime());
		l.setBookId(lendDao.selectMaxId());
		
		book.setSnum(book.getSnum() - 1);
		
		StudentDao studentDao = new StudentDaoImpl();
		Student stu = studentDao.selectStudent(lend.getReaderId());
		stu.setNum(stu.getNum() + 1);
		lendDao.addLend(l, book, stu);
		
		book.setSnum(book.getSnum() - 1);
		this.setMessage("借书成功~");
		
		List<?> list = lendDao.selectBook(lend.getReaderId(), this.getPageNow(), this.getPageSize());
		Pager page = new Pager(pageNow,lendDao.selectBookSize(lend.getReaderId()));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());				//最后显示借书情况；
		request.put("ISBN", lend.getISBN());
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String returnBook() throws Exception{  
		BookDao bookDao = new BookDaoImpl();
		Book book = bookDao.selectBook(lend.getISBN());
		
		if(lend.getISBN() == null || lend.getISBN().equals("")){
			setMessage("ISBN不能为空！");
			return "success";
		}else if(book == null){
			setMessage("不存在该书！");
			return "success";
		}else if(book.getSnum() == book.getCnum()){
			List<?> list = lendDao.selectBook(lend.getReaderId(), this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow,lendDao.selectBookSize(lend.getReaderId()));
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			request.put("ISBN", lend.getISBN());
			setMessage("抱歉，该书未被借出");
			return "success";
		}
		String currentId = lendDao.selectMinIdFromISBN(lend);		//得到当前isbn最小bookId(既是最早借出去的);
		Lend l = lendDao.selectByBookId(currentId);
		StudentDao studentDao = new StudentDaoImpl();
		Student stu = studentDao.selectStudent(l.getReaderId());
		stu.setNum(stu.getNum() - 1);
		book.setSnum(book.getSnum() + 1);
		lendDao.addLend(l, book, stu);
		
		List<?> list = lendDao.selectBook(lend.getReaderId(), this.getPageNow(), this.getPageSize());
		Pager page = new Pager(pageNow,lendDao.selectBookSize(lend.getReaderId()));
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
