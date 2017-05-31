package com.lqh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lqh.DB.DBConn;
import com.lqh.model.Student;


public class StudentDao {
	Connection conn;
	public Student selectByReaderId(String readerId){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from student where readerId=?");
			pstmt.setString(1, readerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Student stu = new Student();
				stu.setReaderId(rs.getString(1));
				stu.setName(rs.getString(2));
				stu.setSex(rs.getBoolean(3) == true ? "男" : "女");
				stu.setBorn(rs.getDate(4));
				stu.setSpec(rs.getString(5));
				stu.setNum(rs.getInt(6));
				
				return stu;
			}else{
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public boolean addStudent(Student stu) {
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("insert into student(readerId,name,sex,born,spec,num) value(?,?,?,?,?,?)");
			pstmt.setString(1, stu.getReaderId());
			pstmt.setString(2, stu.getName());
			pstmt.setBoolean(3, stu.getSex().equals("男") ? true : false);
			pstmt.setDate(4, stu.getBorn());
			pstmt.setString(5, stu.getSpec());
			pstmt.setInt(6, 0);			//初始化为0
			pstmt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public boolean deleteStudent(String readerId) {
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("delete from student where readerId=?");
			pstmt.setString(1, readerId);
			pstmt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public boolean changeStudent(Student stu){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("update student set name=?,sex=?,born=?,spec=? where readerId=?");
			pstmt.setString(1, stu.getName());
			pstmt.setBoolean(2, stu.getSex().equals("男") ? true : false);
			pstmt.setDate(3, stu.getBorn());
			pstmt.setString(4, stu.getSpec());
			pstmt.setString(5, stu.getReaderId());
			pstmt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public void updateStudent(Student stu){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("update student set num=? where readerId=?");
			pstmt.setInt(1, stu.getNum());
			pstmt.setString(2, stu.getReaderId());
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.closeConn();
		}
	}
	
	public boolean isReaderIdExists(String readerId) {
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select readerId from student where readerId=?");
			pstmt.setString(1, readerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}

}
