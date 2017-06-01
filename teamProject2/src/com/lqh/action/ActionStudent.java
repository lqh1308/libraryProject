package com.lqh.action;

import com.lqh.Dao.impl.StudentDaoImpl;
import com.lqh.vo.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionStudent extends ActionSupport{
	private Student student;
	private String message;
	
	//�����û�
	public String addStudent() throws Exception {
		System.out.println("add");
		if(!this.hasReaderId()) {		//��һ��ѡ���ܰ�������û����Ϣ
			System.out.println("addStudent û������ || state != ADD");
			return SUCCESS;
		}
		System.out.println(student);
		if(new StudentDaoImpl().selectStudent(student.getReaderId()) == null) {	//readerId������
			new StudentDaoImpl().addStudent(student);
			this.setMessage("��ӳɹ�");
			return SUCCESS;
		} else {
			this.setMessage("readerId�Ѵ��ڣ���ѡ����readerId");
			return SUCCESS;
		}
	}
	
	//ɾ���û�
	public String deleteStudent() throws Exception {
		System.out.println("delete student : " + student);
		
		if(!this.hasReaderId())	{	//��һ��ѡ���ܰ�������û����Ϣ
			System.out.println("deleteStudent û������");
			return SUCCESS;
		}
		
		if(new StudentDaoImpl().selectStudent(student.getReaderId()) != null) {	//readerId����
			new StudentDaoImpl().deleteStudent(student.getReaderId());
			this.setMessage("ɾ���ɹ�");
			return SUCCESS;
		} else {
			this.setMessage("readerId�����ڣ���ȷ��");
			return SUCCESS;
		}
	}
	
	//�޸��û�
	public String updateStudent() throws Exception {
		System.out.println("update");
		if(!this.hasReaderId()) {		//��һ��ѡ���ܰ�������û����Ϣ
			System.out.println("updateStudent û������");
			return SUCCESS;
		}

		if(new StudentDaoImpl().selectStudent(student.getReaderId()) != null) {	//readerId����
			new StudentDaoImpl().updateStudent(student);
			this.setMessage("�޸ĳɹ�");
			return SUCCESS;
		} else {
			this.setMessage("readerId�����ڣ���ȷ��");
			return SUCCESS;
		}
	}
	
	//��ѯ�û�
	public String selectStudent() throws Exception {
		System.out.println("select student:" + student);
		if(!this.hasReaderId()) {		//��һ��ѡ���ܰ�������û����Ϣ
			System.out.println("selectStudent û������");
			return SUCCESS;
		}
		System.out.println("1");
		Student stu = new StudentDaoImpl().selectStudent(student.getReaderId());
		if(stu != null) {	//readerId����
			ActionContext.getContext().put("stu", stu);
			System.out.println(ActionContext.getContext().get("stu"));
			System.out.println("success");
			this.setMessage("��ѯ�ɹ�");
			return SUCCESS;
		} else {
			this.setMessage("readerId�����ڣ���ȷ��");
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
