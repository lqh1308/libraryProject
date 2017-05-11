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
	//文件上传内容
	private File photo;
	//文件上传类型
	private String photoContentType;
	//文件上传名字
	private String photoFileName;
	
	BookDao bookDao = new BookDao();
	
	public String addBook() throws Exception {     //增加书
		Book bo=bookDao.bookSelect(book.getISBN());
		if(bo!=null){              	 	//判断要添加的图书是否已经存在
			this.setMessage("ISBN已经存在！");
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
			//保存到本地temp目录
			savePhoto(photo, getFile());
			fis.read(buffer);
			b.setPhoto(buffer);
			fis.close();
		}
		bookDao.addBook(b);
		this.setMessage("添加成功！");
		return SUCCESS;
	}
	
	public String deleteBook() throws Exception {			//删除图书信息
		Book b=bookDao.bookSelect(book.getISBN());
		if(b==null){
			this.setMessage("要删除的图书不存在,请检查ISBN号是否正确！");
			return SUCCESS;
		}
		File old = checkFile();
		if(old != null) {
			System.out.println("delete photo" + old.delete());			//删除文件
		}
		bookDao.deleteBook(b);
		this.setMessage("删除成功");
		return SUCCESS;
	}
	public String updateBook() throws Exception {    //修改图书信息
		Book b=bookDao.bookSelect(book.getISBN());
		if(b==null){
			this.setMessage("要修改的图书不存在,请先查看是否存在该图书！");
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
				old.deleteOnExit();			//有重复的isbn文件，删除之
			}
			savePhoto(getPhoto(), getFile());
			fis.read(buffer);
			b.setPhoto(buffer);
			fis.close();
		}
		bookDao.updateBook(b);
		this.setMessage("修改成功！");
		return SUCCESS;
	}
	public String selectBook() throws Exception {
		Book b=bookDao.bookSelect(book.getISBN());
		if(b==null){
			this.setMessage("要查询的图书不存在,请检查ISBN号是否正确！");
			return SUCCESS;
		}
		ActionContext.getContext().put("onebook", b);
		ActionContext.getContext().put("photoAddr", getAddr());
		
		return SUCCESS;
	}
	
	public boolean savePhoto(File originFile, File saveFile){		//保存文件上传的图片到本地temp目录
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(originFile);			//获取文件输入流，输入源为上传的photo
			fos = new FileOutputStream(saveFile);			//获取文件输出流，输出源为temp目录下的对应保存对象的isbn号的图片格式文件
			
			/* 
			 * 标准流输出格式
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
	
	public File checkFile() {		//检查temp里面是否原本有这个ISBN的图片存在
		@SuppressWarnings("deprecation")
		File file = new File(ServletActionContext.getRequest().getRealPath("/temp"));	//获得temp目录
		String[] subFileName = file.list();			//获取temp目录下子文件的文件名列表
		for(String name : subFileName) {
			String str = name.substring(0, name.lastIndexOf("."));		//截取.xxx之前的文件名（即isbn号）
			if(str.equals(this.book.getISBN())) {
				return new File(file.getPath() + "\\" + name);   //返回具体的文件
			}
		}
		return null;
	}
	
	public String checkType() {
		@SuppressWarnings("deprecation")
		File file = new File(ServletActionContext.getRequest().getRealPath("/temp"));	//获得temp目录
		String[] subFileName = file.list();			//获取temp目录下子文件的文件名列表
		for(String name : subFileName) {
			String str = name.substring(0, name.lastIndexOf("."));		//截取.xxx之前的文件名（即isbn号）
//			System.out.println("str : " + str + ", ISBN : " + book.getISBN() + ", result : " + name);
			if(str.equals(this.book.getISBN())) {
				return name;		//截取.xxx文件类型
			}
		}
		return null;
	}
	
	public String getType() {   //获取photo类型
		System.out.println("photoFileName == null ? " + (photoFileName == null));
		if(photoFileName != null)
			return photoFileName.substring(photoFileName.lastIndexOf("."));
		else {
			return "";
		}
	}
	
	@SuppressWarnings("deprecation")
	public File getFile() {     //获取temp文件
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