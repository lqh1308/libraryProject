package com.lqh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lqh.DB.DBConn;
import com.lqh.model.Login;

public class LoginDao {
	Connection conn;
	public Login checkLogin(String name,String password){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from login where name=? " + "and password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Login login = new Login();
				login.setId(rs.getInt(1));
				login.setName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setRole(rs.getBoolean(4));
				return login;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public void createLogin(String name,String password){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("insert into login(name,password,role) value(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setBoolean(3, false);

			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.closeConn();
		}
	}
}
