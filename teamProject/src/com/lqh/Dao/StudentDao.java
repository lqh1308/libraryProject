package com.lqh.Dao;

import javax.xml.crypto.Data;

import com.lqh.DB.DBConn;
import com.lqh.model.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class StudentDao {
	Connection conn;
	public Student selectByReaderId(String readerId){
		try{
			conn = (Connection) DBConn.getConn();
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from student where readerId=?");
			pstmt.setString(1, readerId);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			if(rs.next()){
				Student stu = new Student();
				stu.setReaderId(rs.getString(1));
				stu.setName(rs.getString(2));
				stu.setSex(rs.getBoolean(3));
				stu.setBorn((Data) rs.getDate(4));
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
}
