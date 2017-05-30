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
		if(b.getPhotoType() == null || b.getPhotoType().equals("")) {		//检查有没有图片
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
	public static File getFile(Book b) {     //获取temp文件
		return new File(ServletActionContext.getRequest().getRealPath("") + 
				"\\temp\\" + b.getISBN() + b.getPhotoType());
	}

	public static File checkFile(String isbn) {		//检查temp里面是否原本有这个ISBN的图片存在
		@SuppressWarnings("deprecation")
		File file = new File(ServletActionContext.getRequest().getRealPath("/temp"));	//获得temp目录
		String[] subFileName = file.list();			//获取temp目录下子文件的文件名列表
		for(String name : subFileName) {
			String str = name.substring(0, name.lastIndexOf("."));		//截取.xxx之前的文件名（即isbn号）
			if(str.equals(isbn)) {
				return new File(file.getPath() + "\\" + name);   //返回具体的文件
			}
		}
		return null;
	}
}
