package com.lqh.action;

import java.util.List;
import java.util.Map;

import com.lqh.Dao.BookDao;
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
	public String selectAllLend(){ 								//查看所借书籍；
		if(lend.getReaderId()==null || lend.getReaderId().equals("")){
			this.setMessage("请输入借书证号！");
			return "success";
		}else if(new StudentDao().selectByReaderId(lend.getReaderId()) == null){
			this.setMessage("不存在该学生");
			return "success";
		}
		List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map<String, Object> request = (Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		return "success";
	}
	

//	public String lendBook() throws Exception{                       //在图书馆查询书籍；
//		BookDao bookDao = new BookDao();
//		Map request = (Map) ActionContext.getContext().get("request");
//		
//		if(lend.getISBN() == null || lend.getISBN().equals("")){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			setMessage("ISBN不能为空！");
//		}else if(bookDao.bookSelect(lend.getISBN()) == null){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
//			
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			setMessage("不存在该书！");
//		}else if(bookDao.bookSelect(lend.getISBN()).getSnum() == 0){
//			List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
//			Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
//			request.put("list", list);
//			request.put("page", page);
//			request.put("readerId", lend.getReaderId());
//			setMessage("抱歉，该书当前库存量为0");
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
