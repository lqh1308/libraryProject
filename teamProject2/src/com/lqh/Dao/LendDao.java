package com.lqh.Dao;

import java.util.List;

import com.lqh.vo.Book;
import com.lqh.vo.Lend;
import com.lqh.vo.Student;

public interface LendDao {
	//方法：分页查询指定借书证号的读者所借书籍的信息
	public List<?> selectBook(String readerId, int pageNow, int pageSize);
	//方法：查询指定借书证号的读者所借图书的总数
	public int selectBookSize(String readerId);
	//方法：借书
	public void addLend(Lend lend, Book book, Student student);
	//方法：根据图书ID查询Lend信息
	public Lend selectByBookId(String bookId);
	//方法：根据图书ISBN查询 Lend信息
	public Lend selectByBookISBN(String isbn);
	public String selectMinIdFromISBN(Lend lend);
	public String selectMaxId();
}
