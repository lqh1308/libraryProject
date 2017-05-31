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
	public List<Lend> selectLend(String readerId, int pageNow, int pageSize){
		try{
			List<Lend> list = new ArrayList<Lend>();
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement(
					"select bookId, ISBN, bookName, publisher, price, ltime " +
					"from (select l.bookId, l.ISBN, b.bookName, b.publisher, b.price, l.ltime " +
						"from lend as l, book as b " +
						"where readerId=? and b.ISBN=l.ISBN order by cast(l.bookId as signed integer) DESC LIMIT " + pageSize * (pageNow - 1) + ", " + pageSize + ") as  temp2");
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
				System.out.println("ISBN : " + lend.getISBN());
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
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into " +
					"lend(bookId,readerId,isbn,LTime) " +
					"value(?,?,?,?)");
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
					"price=?,cnum=?,snum=?,summary=?,photoType=? where ISBN = ?");
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthor());
			
			pstmt.setString(3, book.getPublisher());
			pstmt.setFloat(4, book.getPrice());
			pstmt.setInt(5, book.getCnum());
			pstmt.setInt(6, book.getSnum());
			pstmt.setString(7, book.getSummary());
			pstmt.setString(8, book.getPhotoType());
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
	
	public int selectMinIdFromISBN(Lend lend) {
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select bookid from lend where ISBN=? and readerId=? order by cast(bookid as signed integer) limit 0,1");
			pstmt.setString(1, lend.getISBN());
			pstmt.setString(2, lend.getReaderId());
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			if(rs.next()){
				int minId = rs.getInt(1);
				return minId;
			}
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public int selectMaxId(){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select bookid from lend order by cast(bookid as signed integer) DESC limit 0,1");
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			if(rs.next()){
				int maxId = rs.getInt(1);
				return maxId;
			}
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			DBConn.closeConn();
		}
	}


	public boolean dropLend(Lend lend) {
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement(
					"delete from " +
					"lend where bookId=?");
			pstmt.setString(1, lend.getBookId());
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
