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
	
	//�鿴�����鼮��
	public String selectAllLend(){ 		
//		System.out.println(lend);
		if(lend.getReaderId() == null || lend.getReaderId().equals("")){
			this.setMessage("���������֤�ţ�");
			System.out.println("ActionLend.selectAllLend() ��һ���ж�Ϊ��");
			return "success";
		}else if(new StudentDao().selectByReaderId(lend.getReaderId()) == null){
			this.setMessage("�����ڸ�ѧ��");
			System.out.println("ActionLend.selectAllLend() �ڶ����ж�Ϊ��");
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
			setMessage("ISBN����Ϊ�գ�");
			return "success";
		}else if(book == null){
			setMessage("�����ڸ��飡");
			return "success";
		}else if(book.getSnum() == 0){
			List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			request.put("ISBN", lend.getISBN());
			setMessage("��Ǹ�����鵱ǰ�����Ϊ0");
			return "success";
		}
		String currentId = (lendDao.selectMaxId() + 1) + "";											//�õ���ǰ���bookId;
		Date currentTime = new Date(System.currentTimeMillis());            //�õ���ǰʱ��
		lend.setBookId(currentId);
		lend.setLendTime(currentTime);
		try{
			lendDao.addLend(lend);										//�޸Ľ����
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("���½����ʧ��!");
		}
		book.setSnum(book.getSnum() - 1);
		bookDao.updateBook(book);                                   //�޸�book�Ŀ����
		StudentDao stuDao = new StudentDao();
		Student student = stuDao.selectByReaderId(lend.getReaderId());
		student.setNum(student.getNum() + 1);
		stuDao.updateStudent(student);								//�޸�ѧ���Ľ�������
		List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.pageNow, this.pageSize);
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());				//�����ʾ���������
		request.put("ISBN", lend.getISBN());
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String returnBook() throws Exception{  
		BookDao bookDao = new BookDao();
		Book book = bookDao.bookSelect(lend.getISBN());
		
		if(lend.getISBN() == null || lend.getISBN().equals("")){
			setMessage("ISBN����Ϊ�գ�");
			return "success";
		}else if(book == null){
			setMessage("�����ڸ��飡");
			return "success";
		}else if(book.getSnum() == book.getCnum()){
			List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			request.put("ISBN", lend.getISBN());
			setMessage("��Ǹ������δ�����");
			return "success";
		}
		String currentId = lendDao.selectMinIdFromISBN(lend) + "";		//�õ���ǰisbn��СbookId(����������ȥ��);
		lend.setBookId(currentId);
		try{
			lendDao.dropLend(lend);										//�޸Ľ����
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("���½����ʧ��!");
		}
		book.setSnum(book.getSnum() + 1);
		bookDao.updateBook(book);                                   //�޸�book�Ŀ����
		StudentDao stuDao = new StudentDao();
		Student student = stuDao.selectByReaderId(lend.getReaderId());
		student.setNum(student.getNum() - 1);
		stuDao.updateStudent(student);								//�޸�ѧ���Ľ�������
		List<Lend> list = lendDao.selectLend(lend.getReaderId(), this.pageNow, this.pageSize);
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());				//�����ʾ���������
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
