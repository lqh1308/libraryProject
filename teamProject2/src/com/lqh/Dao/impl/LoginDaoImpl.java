package com.lqh.Dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lqh.Dao.LoginDao;
import com.lqh.util.HibernateSessionFactory;
import com.lqh.vo.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Login checkLogin(String name, String password) {		//ʵ�֣���֤�û���Ϣ
		Session session = null;
		Transaction tx = null;
		Login login = null;
		try {
			session = HibernateSessionFactory.getSession();		//�����Ự
			tx = session.beginTransaction();			//��������
			Query query = session.createQuery("from Login where name=? and password=?");
			query.setParameter(0, name);
			query.setParameter(1, password);
			query.setMaxResults(1);
			login = (Login) query.uniqueResult();		//ִ�в�ѯ
			tx.commit();					//�ύ����
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
			session = HibernateSessionFactory.getSession();		//�����Ự
			tx = session.beginTransaction();			//��������
			session.save(new Login(name, password, false));	//�־û��������
			tx.commit();					//�ύ����
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
