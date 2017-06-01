<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	  	<s:form action="s_returnBook" method="post" theme="simple">
  	<table style="margin-top:-302px;">
  		<tr>
  			<td style="margin-left:50px; border:1px solid #CCC; height:40px; width:330px; text-align:center; margin-top:30px; background:#DDD; font-weight:bold;">还书界面</td>
  		</tr>
  		<tr>
  			<td height="80px;" background="#FFF"></td>
  		</tr>
  		<tr>
  			<td style="height:40px; background:#CCC; text-align:left;">
  				<span>您的借书证号：</span><s:textfield name="lend.readerId" size='12'></s:textfield>
  			</td>
  		</tr>
  		<tr>
  			<td style="height:30px; width:300px; text-align:left; margin-top:60px; background:#CCC">
  				<span>图&nbsp;书&nbsp;ISBN：</span><s:textfield name="lend.ISBN" size="12"></s:textfield>
  			</td>
  		</tr>
  		<tr>
  			<td style="height:40px; background:#CCC; text-align:center;">
  				<s:submit value="还书" style="height:20px; width:60px; color:#666;"/>
  			</td>
  		</tr>
  	</table>
  	</s:form>
  </body>
</html>
