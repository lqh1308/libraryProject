<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理系统-管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="style/head.css"/>

  </head>
  
  <body>
  	<div>
	  	<table>
	  		<tr>
	  			<td rowspan="2">
	  			<img src="image/lib-1.jpg" width="420" height="120"/></td>
	  			<td colspan="7" width="700px">
	  			<h1><img src="image/book.jpg" width="30px" height="30px" style="padding-top:10px;">图书管理系统</h1></td>
	  		</tr>
	  		<tr>
	  			<td style="width:50px;"></td>
	  			<td>图书查询</td>
	  			<td><span onclick="location.href='lend/lend.jsp'" style='cursor:hand'>借书查询</span></td>
	  			<td><span onclick="location.href='lendCheck/lendCheck.jsp'" style='cursor:hand'>借书</span></td>
	  			<td>还书</td>
	  			<td>读者管理</td>
	  			<td>图书管理</td>
	  			<td style="padding-right:70px;">关于</td>
	  		</tr>
	  	</table>
  	</div>
  </body>
</html>




















