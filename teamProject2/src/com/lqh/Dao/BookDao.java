package com.lqh.Dao;

import com.lqh.vo.Book;

public interface BookDao {
	public void addBook(Book book);
	public void deleteBook(String isbn);
	public void updateBook(Book book);
	public Book selectBook(String isbn);
}
