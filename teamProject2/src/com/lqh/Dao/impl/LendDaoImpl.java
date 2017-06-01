package com.lqh.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lqh.Dao.LendDao;
import com.lqh.util.HibernateSessionFactory;
import com.lqh.vo.Book;
import com.lqh.vo.Lend;
import com.lqh.vo.Student;

public class LendDaoImpl implements LendDao{
	@Override
	public List<?> selectBook(String readerId, int pageNow, int pageSize) {
		Session session = null;
		Transaction tx = null;
		List<?> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(
					"select l.bookId,l.ISBN,b.bookName,b.publisher,b.price,l.ltime " +
					"from Lend as l, Book as b " +
					"where l.readerId=? and b.ISBN=l.ISBN");
			query.setParameter(0, readerId);
			query.setFirstResult(pageSize * (pageNow - 1));
			query.setMaxResults(pageSize);
			list = query.list();
			
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int selectBookSize(String readerId) {
		Session session = null;
		Transaction tx = null;
		int size = 0;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Lend where readerId=?");
			query.setParameter(0, readerId);
			size = query.list().size();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return size;
	}
	
	@Override
	public void addLend(Lend lend, Book book, Student student) {
		Session session = null;
		Transaction tx = null;
		int size = 0;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(lend);				//添加借书信息
			session.save(book);				//修改图书信息，库存量-1
			session.save(student);			//修改学生信息，借书量+1
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
	public Lend selectByBookId(String bookId) {
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			lend = (Lend) session.get(Lend.class, bookId); 
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lend;
	}
	@Override
	public Lend selectByBookISBN(String isbn) {
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Lend where ISBN=?");
			query.setParameter(0, isbn);
			query.setMaxResults(1);
			lend = (Lend)query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lend;
	}

	public String selectMinIdFromISBN(Lend lend) {
		Session session = null;
		Transaction tx = null;
		String str = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("select bookid from lend where ISBN=? and readerId=? order by CAST(bookid as integer)");
			query.setParameter(0, lend.getISBN());
			query.setParameter(1, lend.getReaderId());
			query.setMaxResults(1);
			str = (String)query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return str;
	}
	@Override
	public String selectMaxId() {
		Session session = null;
		Transaction tx = null;
		String str = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("select max(cast(bookid as integer) + 1) from lend");
			query.setMaxResults(1);
			str = (String)query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return str;
	}
}
