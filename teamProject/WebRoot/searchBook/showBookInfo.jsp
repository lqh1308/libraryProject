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
    
    <title>图书管理里系统</title>
    
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
  	<table style="border:solid 1px #BBB; align:center; width:900px; cellpadding:10px; cellspacing:5px; background:#DDD;">
  		<tr style="background:#EEE; text-align:left;">
  			<td style="font-size:17px; font-weight:bold;">图书信息</td>
  		</tr>
  	<!--  	<s:set name="book" value="#request.book">-->
  		<s:iterator value="#request.book" id="book">
  		<tr>
  			<td>书名：<input type="text" value="<s:property value="#book.bookName"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td>作者：<input type="text" value="<s:property value="#book.author"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td>出版社：<input type="text" value="<s:property value="#book.publisher"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td>价格：<input type="text" value="<s:property value="#book.price"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td>复本量：<input type="text" value="<s:property value="#book.cnum"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td>库存量：<input type="text" value="<s:property value="#book.snum"/>" readonly/></td>
  		</tr>
  		</s:iterator>
  	<!--  	</s:set> -->
  	</table>
  </body>
</html>


















