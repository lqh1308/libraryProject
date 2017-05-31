package com.lqh.model;

import java.sql.Date;


public class Student {
	private String readerId;
	private String name;
	private String spec;
	private String sex;
	private Date born;
	private int num;
	
	@Override
	public String toString() {
		return "readerId:" + readerId + ", name:" + name + 
				", spec:" + spec + ", sex:" + sex + ", born:" + born + 
				", num:" + num;
	}
	
	public void setInit() {
		readerId = "";
		name = "";
		spec = "";
		sex = "ÄÐ";
		born = null;
		num = 0;
	}
	
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
