package com.lqh.Dao;

import com.lqh.vo.Login;

public interface LoginDao {
	public Login checkLogin(String name, String password);		//��������֤�û���Ϣ

	public boolean createLogin(String name, String password);		//������ע���¼�û�
}
