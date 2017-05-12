package com.lqh.action;

import java.util.ArrayList;
import java.util.List;

import com.lqh.Dao.BookDao;
import com.lqh.model.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionSearch extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String message;
	private Book book;
	
	public String searchBook(){
		if(book.getISBN() == null || book.getISBN().equals("")){
			this.message = "������ͼ��ISBN!";
			return "success";
		}else if(new BookDao().bookSelect(book.getISBN()) == null){
			this.message = "�����ڸ�ͼ��";
			return "success";
		}
		List<Book> list = new ArrayList<Book>();
		list.add(new BookDao().bookSelect(book.getISBN()));
		Book bookS = new Book();
		bookS = (Book) list.get(0);										//���ͼ�����Ϣ
	//	System.out.println(bookS.getAuthor());
		
		ActionContext request = (ActionContext)ActionContext.getContext().get("request");
		request.put("book", bookS);
		Book book1 = (Book) request.get("book");
		System.out.println(book1.getAuthor());
		
//		this.message = "���ڸ��飡";
		return "success";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
