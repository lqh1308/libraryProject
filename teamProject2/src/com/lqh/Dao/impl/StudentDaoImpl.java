package com.lqh.Dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lqh.Dao.StudentDao;
import com.lqh.util.HibernateSessionFactory;
import com.lqh.vo.Student;

public class StudentDaoImpl implements StudentDao{
	@Override
	public void addStudent(Student student) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	@Override
	public void deleteStudent(String readerId) {
		Session session = null;
		Transaction tx = null;
		try {
			Student student = this.selectStudent(readerId);
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	@Override
	public Student selectStudent(String readerId) {
		Session session = null;
		Transaction tx = null;
		Student student = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, readerId);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}
	@Override
	public void updateStudent(Student student) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
