package com.lqh.Dao;

import java.util.ArrayList;
import java.util.List;

import com.lqh.DB.DBConn;
import com.lqh.model.Lend;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class LendDao {
	Connection conn;
	public List selectLend(String readerId, int pageNow, int pageSize){
		try{
			List list = new ArrayList();
			conn = (Connection) DBConn.getConn();
			PreparedStatement pstmt = (PreparedStatement) conn.prepareCall("select top" + pageSize + "l.bookId,l.ISBN," +
					"b.bookName,b.publisher,b.price,l.ltime from lend as l,book as b where readerId = ? and b.ISBN = l.ISBN" +
					"and l.bookId not in (select top" + pageSize*(pageNow-1) + "l.bookId from lend as l)");
			pstmt.setString(1, readerId);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while(rs.next()){
				Lend lend = new Lend();
				
				lend.setBookId(rs.getString(1));
				lend.setISBN(rs.getString(2));
				lend.setBookName(rs.getString(3));
				lend.setPublisher(rs.getString(4));
				lend.setPrice(rs.getFloat(5));
				lend.setLendTime(rs.getDate(6));
				
				list.add(lend);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.closeConn();
		}
	}
	
	
	public int selectLendSize(String readerId){
		try{
			conn = (Connection) DBConn.getConn();
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select count(*) from lend where readerId = ?");
			pstmt.setString(1, readerId);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			if(rs.next()){
				int pageCount = rs.getInt(1);
				return pageCount;
			}
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			DBConn.closeConn();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
