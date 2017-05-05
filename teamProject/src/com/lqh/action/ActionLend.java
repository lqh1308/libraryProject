package com.lqh.action;

import java.util.List;
import java.util.Map;

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
	public String selectAllLend(){
		if(lend.getReadId()==null || lend.getReadId().equals("")){
			this.setMessage("请输入借书证号！");
			return SUCCESS;
		}else if(new StudentDao().selectByReaderId(lend.getReadId()) == null){
			this.setMessage("不存在该学生");
			return SUCCESS;
		}
		List list = lendDao.selectLend(lend.getReadId(), this.getPageNow(), this.getPageSize());
		Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReadId()));
		Map<String, Object> request = (Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReadId());
		return SUCCESS;
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
