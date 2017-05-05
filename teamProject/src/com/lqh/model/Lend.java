package com.lqh.model;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Lend {
	private String bookId;
	private String readerId;
	private String bookName;
	private String ISBN;
	private Date lendTime;
	private float price;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getReadId() {
		return readerId;
	}
	public void setReadId(String readId) {
		this.readerId = readId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Data getLendTime() {
		return (Data) lendTime;
	}
	public void setLendTime(Date date) {
		this.lendTime = date;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float f) {
		this.price = f;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	private String publisher;
	
	
}
