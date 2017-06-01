package com.lqh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lqh.Dao.BookDao;
import com.lqh.Dao.impl.BookDaoImpl;
import com.lqh.util.PhotoTools;
import com.lqh.vo.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionBook extends ActionSupport {
	private String message;
	private Book book;
	//�ļ��ϴ�����
	private File photo;
	//�ļ��ϴ�����
	private String photoContentType;
	//�ļ��ϴ�����
	private String photoFileName;
	
	BookDao bookDao = new BookDaoImpl();
	
	public String addBook() throws Exception {     //������
		Book bo = bookDao.selectBook(book.getISBN());
		if(bo != null){              	 	//�ж�Ҫ��ӵ�ͼ���Ƿ��Ѿ�����
			this.setMessage("ISBN�Ѿ����ڣ�");
			return SUCCESS;
		}
		Book b=new Book();
		b.setISBN(book.getISBN());
		b.setBookName(book.getBookName());
		b.setAuthor(book.getAuthor());
		b.setPublisher(book.getPublisher());
		b.setPrice(book.getPrice());
		b.setCnum(book.getCnum());
		b.setSnum(book.getCnum());
		b.setSummary(book.getSummary());
		if(this.getPhoto()!=null){
			//���浽����tempĿ¼
			savePhoto(this.getPhoto(), PhotoTools.getFile(book));
			//����ͼƬ��׺
			b.setPhotoType(photoFileName.substring(photoFileName.lastIndexOf('.')));
		}
		bookDao.addBook(b);
		this.setMessage("��ӳɹ���");
		return SUCCESS;
	}
	
	public String deleteBook() throws Exception {			//ɾ��ͼ����Ϣ
		Book b=bookDao.selectBook(book.getISBN());
		if(b==null){
			this.setMessage("Ҫɾ����ͼ�鲻����,����ISBN���Ƿ���ȷ��");
			return SUCCESS;
		}
		File old = PhotoTools.checkFile(book.getISBN());
		if(old != null) {
			//ɾ���ļ�
			old.delete();			
		}
		bookDao.deleteBook(b.getISBN());
		this.setMessage("ɾ���ɹ�");
		return SUCCESS;
	}
	public String updateBook() throws Exception {    //�޸�ͼ����Ϣ
		Book b=bookDao.selectBook(book.getISBN());
		if(b==null){
			this.setMessage("Ҫ�޸ĵ�ͼ�鲻����,���Ȳ鿴�Ƿ���ڸ�ͼ�飡");
			return SUCCESS;
		}
		b.setISBN(book.getISBN());
		b.setBookName(book.getBookName());
		b.setAuthor(book.getAuthor());
		b.setPublisher(book.getPublisher());
		b.setPrice(book.getPrice());
		b.setCnum(book.getCnum());
		b.setSnum(book.getSnum());
		b.setSummary(book.getSummary());
		if(this.getPhoto()!=null){
			File old = PhotoTools.checkFile(book.getISBN());
			if(old != null) {
				old.deleteOnExit();			//���ظ���isbn�ļ���ɾ��֮
			}
			savePhoto(this.getPhoto(), PhotoTools.getFile(book));
		}
		bookDao.updateBook(b);
		this.setMessage("�޸ĳɹ���");
		return SUCCESS;
	}
	
	public String selectBook() throws Exception {
		Book b=bookDao.selectBook(book.getISBN());
		if(b==null){
			this.setMessage("Ҫ��ѯ��ͼ�鲻����,����ISBN���Ƿ���ȷ��");
			return SUCCESS;
		}
		ActionContext.getContext().put("onebook", b);
		ActionContext.getContext().put("photoAddr", PhotoTools.getPhotoUrl(b));
		
		return SUCCESS;
	}
	
	public boolean savePhoto(File originFile, File saveFile){		//�����ļ��ϴ���ͼƬ������tempĿ¼
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(originFile);			//��ȡ�ļ�������������ԴΪ�ϴ���photo
			fos = new FileOutputStream(saveFile);			//��ȡ�ļ�����������ԴΪtempĿ¼�µĶ�Ӧ��������isbn�ŵ�ͼƬ��ʽ�ļ�
			
			byte[] buffer = new byte[1024];				
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

}