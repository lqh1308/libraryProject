package com.lqh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lqh.Dao.BookDao;
import com.lqh.model.Book;
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
	
	BookDao bookDao = new BookDao();
	
	public String addBook() throws Exception {     //������
		Book bo=bookDao.bookSelect(book.getISBN());
		if(bo!=null){              	 	//�ж�Ҫ��ӵ�ͼ���Ƿ��Ѿ�����
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
			FileInputStream fis=new FileInputStream(this.getPhoto());
			byte[] buffer=new byte[fis.available()];
			//���浽����tempĿ¼
			savePhoto(photo, getFile());
			fis.read(buffer);
			b.setPhoto(buffer);
			fis.close();
		}
		bookDao.addBook(b);
		this.setMessage("��ӳɹ���");
		return SUCCESS;
	}
	
	public String deleteBook() throws Exception {			//ɾ��ͼ����Ϣ
		Book b=bookDao.bookSelect(book.getISBN());
		if(b==null){
			this.setMessage("Ҫɾ����ͼ�鲻����,����ISBN���Ƿ���ȷ��");
			return SUCCESS;
		}
		File old = checkFile();
		if(old != null) {
			System.out.println("delete photo" + old.delete());			//ɾ���ļ�
		}
		bookDao.deleteBook(b);
		this.setMessage("ɾ���ɹ�");
		return SUCCESS;
	}
	public String updateBook() throws Exception {    //�޸�ͼ����Ϣ
		Book b=bookDao.bookSelect(book.getISBN());
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
			FileInputStream fis=new FileInputStream(this.getPhoto());
			byte[] buffer=new byte[fis.available()];
			File old = checkFile();
			if(old != null) {
				old.deleteOnExit();			//���ظ���isbn�ļ���ɾ��֮
			}
			savePhoto(getPhoto(), getFile());
			fis.read(buffer);
			b.setPhoto(buffer);
			fis.close();
		}
		bookDao.updateBook(b);
		this.setMessage("�޸ĳɹ���");
		return SUCCESS;
	}
	public String selectBook() throws Exception {
		Book b=bookDao.bookSelect(book.getISBN());
		if(b==null){
			this.setMessage("Ҫ��ѯ��ͼ�鲻����,����ISBN���Ƿ���ȷ��");
			return SUCCESS;
		}
		ActionContext.getContext().put("onebook", b);
		ActionContext.getContext().put("photoAddr", getAddr());
		
		return SUCCESS;
	}
	
	public boolean savePhoto(File originFile, File saveFile){		//�����ļ��ϴ���ͼƬ������tempĿ¼
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(originFile);			//��ȡ�ļ�������������ԴΪ�ϴ���photo
			fos = new FileOutputStream(saveFile);			//��ȡ�ļ�����������ԴΪtempĿ¼�µĶ�Ӧ��������isbn�ŵ�ͼƬ��ʽ�ļ�
			
			/* 
			 * ��׼�������ʽ
			 */
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
	
	public File checkFile() {		//���temp�����Ƿ�ԭ�������ISBN��ͼƬ����
		@SuppressWarnings("deprecation")
		File file = new File(ServletActionContext.getRequest().getRealPath("/temp"));	//���tempĿ¼
		String[] subFileName = file.list();			//��ȡtempĿ¼�����ļ����ļ����б�
		for(String name : subFileName) {
			String str = name.substring(0, name.lastIndexOf("."));		//��ȡ.xxx֮ǰ���ļ�������isbn�ţ�
			if(str.equals(this.book.getISBN())) {
				return new File(file.getPath() + "\\" + name);   //���ؾ�����ļ�
			}
		}
		return null;
	}
	
	public String checkType() {
		@SuppressWarnings("deprecation")
		File file = new File(ServletActionContext.getRequest().getRealPath("/temp"));	//���tempĿ¼
		String[] subFileName = file.list();			//��ȡtempĿ¼�����ļ����ļ����б�
		for(String name : subFileName) {
			String str = name.substring(0, name.lastIndexOf("."));		//��ȡ.xxx֮ǰ���ļ�������isbn�ţ�
//			System.out.println("str : " + str + ", ISBN : " + book.getISBN() + ", result : " + name);
			if(str.equals(this.book.getISBN())) {
				return name;		//��ȡ.xxx�ļ�����
			}
		}
		return null;
	}
	
	public String getType() {   //��ȡphoto����
		System.out.println("photoFileName == null ? " + (photoFileName == null));
		if(photoFileName != null)
			return photoFileName.substring(photoFileName.lastIndexOf("."));
		else {
			return "";
		}
	}
	
	@SuppressWarnings("deprecation")
	public File getFile() {     //��ȡtemp�ļ�
		return new File(ServletActionContext.getRequest().getRealPath("") + 
				"\\temp\\" + getBook().getISBN() + getType());
	}
	
	public String getAddr() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String scheme = req.getScheme();
		String basePath = req.getServerName();
		int port = req.getServerPort();
		String contextPath = req.getContextPath();
		String result = scheme + "://" + basePath + ":" + port + contextPath + "/temp/" + checkType();
//		System.out.println("checkType()" + checkType());
//		System.out.println("photo url:" + result);
		return result;
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