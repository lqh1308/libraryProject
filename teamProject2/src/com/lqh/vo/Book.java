package com.lqh.vo;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private String ISBN;
	private String bookName;
	private String author;
	private String publisher;
	private Float price;
	private Integer cnum;
	private Integer snum;
	private String summary;
	private String photoType;
	private String photo_url;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String ISBN, String bookName, String author, String publisher, Float price,
			Integer cnum, Integer snum) {
		this.ISBN = ISBN;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.cnum = cnum;
		this.snum = snum;
	}

	/** full constructor */
	public Book(String ISBN, String bookName, String author, String publisher, Float price,
			Integer cnum, Integer snum, String summary, String photoType) {
		this.ISBN = ISBN;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.cnum = cnum;
		this.snum = snum;
		this.summary = summary;
		this.photoType = photoType;
	}

	// Property accessors

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getCnum() {
		return this.cnum;
	}

	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}

	public Integer getSnum() {
		return this.snum;
	}

	public void setSnum(Integer snum) {
		this.snum = snum;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPhotoType() {
		return this.photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

}