package com.lqh.action;

import com.lqh.Dao.impl.StudentDaoImpl;
import com.lqh.vo.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionStudent extends ActionSupport{
	private Student student;
	private String message;
	
	//增加用户
	public String addStudent() throws Exception {
		System.out.println("add");
		if(!this.hasReaderId()) {		//第一次选择功能按键，还没有信息
			System.out.println("addStudent 没有输入 || state != ADD");
			return SUCCESS;
		}
		System.out.println(student);
		if(new StudentDaoImpl().selectStudent(student.getReaderId()) == null) {	//readerId不存在
			new StudentDaoImpl().addStudent(student);
			this.setMessage("添加成功");
			return SUCCESS;
		} else {
			this.setMessage("readerId已存在，请选择新readerId");
			return SUCCESS;
		}
	}
	
	//删除用户
	public String deleteStudent() throws Exception {
		System.out.println("delete student : " + student);
		
		if(!this.hasReaderId())	{	//第一次选择功能按键，还没有信息
			System.out.println("deleteStudent 没有输入");
			return SUCCESS;
		}
		
		if(new StudentDaoImpl().selectStudent(student.getReaderId()) != null) {	//readerId存在
			new StudentDaoImpl().deleteStudent(student.getReaderId());
			this.setMessage("删除成功");
			return SUCCESS;
		} else {
			this.setMessage("readerId不存在，请确认");
			return SUCCESS;
		}
	}
	
	//修改用户
	public String updateStudent() throws Exception {
		System.out.println("update");
		if(!this.hasReaderId()) {		//第一次选择功能按键，还没有信息
			System.out.println("updateStudent 没有输入");
			return SUCCESS;
		}

		if(new StudentDaoImpl().selectStudent(student.getReaderId()) != null) {	//readerId存在
			new StudentDaoImpl().updateStudent(student);
			this.setMessage("修改成功");
			return SUCCESS;
		} else {
			this.setMessage("readerId不存在，请确认");
			return SUCCESS;
		}
	}
	
	//查询用户
	public String selectStudent() throws Exception {
		System.out.println("select student:" + student);
		if(!this.hasReaderId()) {		//第一次选择功能按键，还没有信息
			System.out.println("selectStudent 没有输入");
			return SUCCESS;
		}
		System.out.println("1");
		Student stu = new StudentDaoImpl().selectStudent(student.getReaderId());
		if(stu != null) {	//readerId存在
			ActionContext.getContext().put("stu", stu);
			System.out.println(ActionContext.getContext().get("stu"));
			System.out.println("success");
			this.setMessage("查询成功");
			return SUCCESS;
		} else {
			this.setMessage("readerId不存在，请确认");
			return SUCCESS;
		}
	}
	
	private boolean hasReaderId() {
		if(this.student == null || this.student.getReaderId() == null || this.student.getReaderId().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		System.out.println(message);
	}
}
