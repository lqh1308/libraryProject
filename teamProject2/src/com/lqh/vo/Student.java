package com.lqh.vo;

import java.sql.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String readerId;
	private String name;
	private Boolean sex;
	private Date born;
	private String spec;
	private Integer num;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String name, Boolean sex, Date born, String spec,
			Integer num) {
		this.name = name;
		this.sex = sex;
		this.born = born;
		this.spec = spec;
		this.num = num;
	}

	// Property accessors

	public String getReaderId() {
		return this.readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Date getBorn() {
		return this.born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}