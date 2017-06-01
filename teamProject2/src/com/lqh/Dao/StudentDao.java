package com.lqh.Dao;

import com.lqh.vo.Student;

public interface StudentDao {
	public void addStudent(Student student);
	public void deleteStudent(String readerId);
	public void updateStudent(Student student);
	public Student selectStudent(String readerId);
}
