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
	<style>
		th{
			font-weight:bold; 
			text-align:center;
			border:1px solid #FFF; 
			backgrond:#EEE;
			margin-left:2px;
		}
	</style>
  </head>
  
  <body>
    <table style="border:solid 1px #BBB; align:center; width:900px; cellpadding:10px; cellspacing:5px; background:#DDD;">
  		<tr>
  			<th>图书ID</th><th>ISBN</th><th>书名</th><th>出版社</th><th>价格</th><th>借书时间</th>
  		</tr>
  		<s:iterator value="#request.list" id="bookLend">
  			<tr>
  				<td style="height:50px; border:1px solid #AAA;"><s:property value="#bookLend.bookId"/></td>
  				<td style="height:50px; border:1px solid #AAA;"><s:property value="#bookLend.ISBN"/></td>
  				<td style="height:50px; border:1px solid #AAA;"><s:property value="#bookLend.bookName"/></td>
  				<td style="height:50px; border:1px solid #AAA;"><s:property value="#bookLend.publisher"/></td>
  				<td style="height:50px; border:1px solid #AAA;"><s:property value="#bookLend.price"/></td>
  				<td style="height:50px; border:1px solid #AAA;"><s:property value="#bookLend.lendTime"/></td>
  			</tr>
  		</s:iterator>
  	</table>
  </body>
</html>
