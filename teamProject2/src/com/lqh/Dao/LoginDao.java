package com.lqh.Dao;

import com.lqh.vo.Login;

public interface LoginDao {
	public Login checkLogin(String name, String password);		//方法：验证用户信息

	public boolean createLogin(String name, String password);		//方法：注册登录用户
}
