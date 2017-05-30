package com.lqh.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lqh.model.Book;

public class PhotoTools {
	private static String DEFAULT_PHOTO = "default_photo.png";
	public static String getPhotoUrl(Book b) {
		HttpServletRequest req = ServletActionContext.getRequest();
		String scheme = req.getScheme();
		String basePath = req.getServerName();
		int port = req.getServerPort();
		String contextPath = req.getContextPath();
		String result = null;
		if(b.getPhotoType() == null || b.getPhotoType().equals("")) {		//�����û��ͼƬ
			result = scheme + "://" + basePath + ":" + port + contextPath + "/temp/" + DEFAULT_PHOTO;
			System.out.println("result: " + result);
			return result;
		}
		
		File file = checkFile(b.getISBN());
		if(file != null) {
			result = scheme + "://" + basePath + ":" + port + contextPath + "/temp/" + file.getName();
			System.out.println("file is not null and the result: " + result);
			return result;
		}
		result = scheme + "://" + basePath + ":" + port + contextPath + "/temp/" + DEFAULT_PHOTO;
		System.out.println("result: " + result);
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static File getFile(Book b) {     //��ȡtemp�ļ�
		return new File(ServletActionContext.getRequest().getRealPath("") + 
				"\\temp\\" + b.getISBN() + b.getPhotoType());
	}

	public static File checkFile(String isbn) {		//���temp�����Ƿ�ԭ�������ISBN��ͼƬ����
		@SuppressWarnings("deprecation")
		File file = new File(ServletActionContext.getRequest().getRealPath("/temp"));	//���tempĿ¼
		String[] subFileName = file.list();			//��ȡtempĿ¼�����ļ����ļ����б�
		for(String name : subFileName) {
			String str = name.substring(0, name.lastIndexOf("."));		//��ȡ.xxx֮ǰ���ļ�������isbn�ţ�
			if(str.equals(isbn)) {
				return new File(file.getPath() + "\\" + name);   //���ؾ�����ļ�
			}
		}
		return null;
	}
}
