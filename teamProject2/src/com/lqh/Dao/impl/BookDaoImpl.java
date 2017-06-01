package com.lqh.Dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lqh.Dao.BookDao;
import com.lqh.util.HibernateSessionFactory;
import com.lqh.vo.Book;

public class BookDaoImpl implements BookDao{
	@Override
	public void addBook(Book book) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(book);
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
	public void deleteBook(String isbn) {
		Session session = null;
		Transaction tx = null;
		try {
			Book book = this.selectBook(isbn);
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.delete(book);
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
	public Book selectBook(String isbn) {
		Session session = null;
		Transaction tx = null;
		Book book = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Book where isbn=?");
			query.setParameter(0, isbn);
			query.setMaxResults(1);
			book = (Book) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return book;
	}
	@Override
	public void updateBook(Book book) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(book);
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
