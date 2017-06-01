package com.lqh.Dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lqh.Dao.LoginDao;
import com.lqh.util.HibernateSessionFactory;
import com.lqh.vo.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Login checkLogin(String name, String password) {		//实现：验证用户信息
		Session session = null;
		Transaction tx = null;
		Login login = null;
		try {
			session = HibernateSessionFactory.getSession();		//创建会话
			tx = session.beginTransaction();			//创建事务
			Query query = session.createQuery("from Login where name=? and password=?");
			query.setParameter(0, name);
			query.setParameter(1, password);
			query.setMaxResults(1);
			login = (Login) query.uniqueResult();		//执行查询
			tx.commit();					//提交事务
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return login;
	}
	
	@Override
	public boolean createLogin(String name, String password) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();		//创建会话
			tx = session.beginTransaction();			//创建事务
			session.save(new Login(name, password, false));	//持久化保存对象
			tx.commit();					//提交事务
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

}
