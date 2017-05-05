package com.lqh.action;

import java.util.Map;

import com.lqh.Dao.LoginDao;
import com.lqh.model.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTest1 extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Login login;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		LoginDao loginDao = new LoginDao();
		Login l = loginDao.checkLogin(login.getName(), login.getPassword());
		if(l != null){
		//	System.out.println(l.getName());
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("login", l);
			if(l.isRole()){
				return "admin";
			}
			else{
				return "student";
			}
		}else{
			return ERROR;
		}
	}
	
	public Login getLogin(){
		return login;
	}
	
	public void setLogin(Login login){
		this.login =  login;
	}
}
