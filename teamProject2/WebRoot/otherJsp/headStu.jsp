<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<link rel="stylesheet" type="text/css" href="style/head.css">
	
  </head>
  
 <body>
  	<div>
	  	<table>
	  		<tr>
	  			<td rowspan="2">
	  			<img src="image/lib3.jpg" width="420" height="120"/></td>
	  			<td colspan="7" width="700px">
	  			<h1><img src="image/book.jpg" width="30px" height="30px" style="padding-top:10px;">图书查询系统</h1></td>
	  		</tr>
	  		<tr style="font-size:20px; font-weight:bold; color:#666;">
	  			<td style="width:150px;"></td>
	  			<td><span onclick="location.href='searchBook/S-search.jsp'" style="cursor:hand">图书查询</span></td>
	  			<td><span onclick="location.href='lend/S-lend.jsp'" style="cursor:hand">借书查询</span></td>
	  			<td><span onclick="location.href='lendCheck/S-lendCheck.jsp'" style='cursor:hand'>借书</span></td>
	  			<td><span onclick="location.href='returnBook/S-return.jsp'" style="cursor:hand">还书</span></td>
	  			<td><span onclick="location.href='about/S-about.jsp'" style='cursor:hand'>关于</span></td>
	  			<td style="width:50px; padding-right:30px;"></td>
	  		</tr>
	  	</table>
  	</div>
  </body>
</html>
