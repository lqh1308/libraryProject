package com.lqh.action;

import com.lqh.Dao.BookDao;
import com.lqh.model.Book;
import com.lqh.util.PhotoTools;
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
		Book bookS = new BookDao().bookSelect(book.getISBN());
		bookS.setPhoto_url(PhotoTools.getPhotoUrl(bookS));
	//	System.out.println(bookS.getAuthor());
		
		ActionContext.getContext().put("book", bookS);
		
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
