package com.lqh.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection conn;
	
	public static Connection getConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","123456");
		//	System.out.println("连接成功！");
			return conn;
		}catch(Exception e){
			e.printStackTrace();
		//	System.out.println("连接失败！");
			return null;
		}
	}
	
	public static void main(String[] args) {
		getConn();
		closeConn();
	}
	
	public static void closeConn() {
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
