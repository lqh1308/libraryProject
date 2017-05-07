package com.lqh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lqh.DB.DBConn;
import com.lqh.model.Book;

public class BookDao {
	Connection conn;
	public Book bookSelect(String ISBN){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from book where ISBN=?");
			pstmt.setString(1, ISBN);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Book book = new Book();
				book.setISBN(rs.getString(1));
				book.setBookName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getFloat(5));
				book.setCnum(rs.getInt(6));
				book.setSnum(rs.getInt(7));
				book.setSummary(rs.getString(8));
				book.setPhoto(rs.getBytes(9));
				return book;
			}else{
				return null;
			}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DBConn.closeConn();
		}
	}
}
