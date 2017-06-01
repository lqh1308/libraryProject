package com.lqh.Dao;

import java.util.List;

import com.lqh.vo.Book;
import com.lqh.vo.Lend;
import com.lqh.vo.Student;

public interface LendDao {
	//��������ҳ��ѯָ������֤�ŵĶ��������鼮����Ϣ
	public List<?> selectBook(String readerId, int pageNow, int pageSize);
	//��������ѯָ������֤�ŵĶ�������ͼ�������
	public int selectBookSize(String readerId);
	//����������
	public void addLend(Lend lend, Book book, Student student);
	//����������ͼ��ID��ѯLend��Ϣ
	public Lend selectByBookId(String bookId);
	//����������ͼ��ISBN��ѯ Lend��Ϣ
	public Lend selectByBookISBN(String isbn);
	public String selectMinIdFromISBN(Lend lend);
	public String selectMaxId();
}
