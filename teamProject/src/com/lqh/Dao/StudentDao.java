package com.lqh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
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
				stu.setSex(rs.getBoolean(3));
				stu.setBorn((Date)rs.getDate(4));
				stu.setSpec(rs.getString(5));
				stu.setNum(rs.getInt(6));
				stu.setPhoto(rs.getBytes(7));
				
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
}
