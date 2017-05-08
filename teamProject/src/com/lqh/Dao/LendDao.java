package com.lqh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.lqh.DB.DBConn;
import com.lqh.model.Book;
import com.lqh.model.Lend;

public class LendDao {
	Connection conn;
	public List selectLend(String readerId, int pageNow, int pageSize){
		try{
			List list = new ArrayList();
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from (select l.bookId, l.ISBN, b.bookName, b.publisher, b.price, l.ltime " + 
					"from lend as l, book as b " +
					"where readerId=? and b.ISBN=l.ISBN and l.bookId " +
					"not in (select temp.bookId from (select bookId from lend LIMIT  0 ," + pageSize*(pageNow-1) + ") as temp) LIMIT 0, " + pageSize + ") as  temp2");
			pstmt.setString(1, readerId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setISBN(rs.getString(2));
				lend.setBookName(rs.getString(3));
				lend.setPublisher(rs.getString(4));
				lend.setPrice(rs.getFloat(5));
				lend.setLendTime(rs.getDate(6));
			//	System.out.println(rs.getDate(6));
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
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from lend where readerId = ?");
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
	
	
	public Lend selectByBookId(String bookId){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from lend where bookId=?");
			pstmt.setString(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setReaderId(rs.getString(2));
				lend.setISBN(rs.getString(3));
				lend.setLendTime(rs.getDate(4));
				return lend;
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
	
	
	public boolean addLend(Lend lend){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("insert into lend value(?,?,?,?");
			pstmt.setString(1, lend.getBookId());
			pstmt.setString(2, lend.getReaderId());
			pstmt.setString(3, lend.getISBN());
			pstmt.setDate(4, lend.getLendTime());
			pstmt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public boolean updateBook(Book book){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("update book set bookName=?,author=?,publisher=?," +
					"price=?,cnum=?,snum=?,summary=?,photo=? where ISBN = ?");
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setFloat(4, book.getPrice());
			pstmt.setInt(5, book.getCnum());
			pstmt.setInt(6, book.getSnum());
			pstmt.setString(7, book.getSummary());
			pstmt.setBytes(8, book.getPhoto());
			pstmt.setString(9, book.getISBN());
			pstmt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}
}
