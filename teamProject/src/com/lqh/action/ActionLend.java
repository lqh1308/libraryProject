package com.lqh.action;

import java.util.List;

import com.lqh.Dao.LendDao;
import com.lqh.Dao.StudentDao;
import com.lqh.model.Lend;
import com.lqh.model.Pager;
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
	

//	public String lendBook() throws Exception{                       //��ͼ��ݲ�ѯ�鼮��
//		BookDao bookDao = new BookDao();
//		Map request = (Map) ActionContext.getContext().get("request");
//		
//		if(lend.getISBN() == null || lend.getISBN().equals("")){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			setMessage("ISBN����Ϊ�գ�");
//		}else if(bookDao.bookSelect(lend.getISBN()) == null){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
//			
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			setMessage("�����ڸ��飡");
//		}else if(bookDao.bookSelect(lend.getISBN()).getSnum() == 0){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			setMessage("��Ǹ�����鵱ǰ�����Ϊ0");
//		}else if(lend.getBookId() == null || lend.getBookId().equals("") 
//				|| lendDao.selectByBookId(lend.getReaderId()) != null){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow, lendDao.selectLendSize(lend.getReaderId()));
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			this.setMessage("");
//		}
//	}
//	
	
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
