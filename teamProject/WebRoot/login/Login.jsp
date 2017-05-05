<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="style/login.css"/> 

  </head>
  
  <body>
  	<s:form action="login" method="post" theme="simple">
  		<h1>图书管理系统登录页面</h1>
  		<div>
	  		<table>
	  			<caption>用户登录</caption>
	  			<tr>
	  				<td>登录名：<s:textfield name="login.name" size="20"></s:textfield></td>
	  			</tr>
	  			<tr>
	  				<td>密&nbsp;码：<s:password name="login.password" size="20"></s:password></td>
	  			</tr>
	  			<tr>
	  				<td>&nbsp;&nbsp;&nbsp;&nbsp;
	  					<s:submit name="submit" value="登录"/>&nbsp;
	  					<s:reset name="reset" value="重置"/>
	  				</td>
	  			</tr>
	  		</table>
  		</div>
  	</s:form>
  </body>
</html>
