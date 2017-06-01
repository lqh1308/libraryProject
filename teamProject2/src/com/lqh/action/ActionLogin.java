package com.lqh.action;

import java.util.Map;

import com.lqh.Dao.LoginDao;
import com.lqh.Dao.impl.LoginDaoImpl;
import com.lqh.vo.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionLogin extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Login login;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		LoginDao loginDao = new LoginDaoImpl();
		System.out.println(login.getName() + login.getPassword());
		Login l = loginDao.checkLogin(login.getName(), login.getPassword());
		if(l != null){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("login", l);
			if(l.getRole()){
				return "admin";
			}
			else{
				return "student";
			}
		}else{
			return ERROR;
		}
	}
	
	public String register() throws Exception {
		LoginDao loginDao = new LoginDaoImpl();
		Login l = loginDao.checkLogin(login.getName(), login.getPassword());
		if(l != null) {
			addFieldError("×¢²á´íÎó", "ÒÑ´æÔÚÕÊºÅÃÜÂë¡£");
			return "input";
		}
		if(loginDao.createLogin(login.getName(), login.getPassword())) {
			addFieldError("×¢²á³É¹¦", "ÇëµÇÂ¼¡£");
		} else {
			addFieldError("×¢²áÊ§°Ü", "ÇëÖØÊÔ¡£");
		}
		return "input";
		
	}
	
	@Override
	public void validate() {
		super.validate();
		if(login.getName() == null || login.getName().equals(""))
			addFieldError("µÇÂ¼Ê§°Ü", "ÓÃ»§Ãû²»ÄÜÎª¿Õ£¡");
		if(login.getPassword() == null || login.getPassword().equals(""))
			addFieldError("µÇÂ¼Ê§°Ü", "ÃÜÂë²»ÄÜÎª¿Õ£¡");
	}
	
	public Login getLogin(){
		return login;
	}
	
	public void setLogin(Login login){
		this.login =  login;
	}
}
