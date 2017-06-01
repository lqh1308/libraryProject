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

	<script>
		window.onload(){
			showMes(book.bookName);
		}
		
		function showMes(mes){
			alert(mes);
		};
	</script>
	-->

	<style type="text/css">
		tr{
			height:50px;
			padding-left:-80px;
		}
		span{
			font-size:17px;
			font-weight:bold;
			color:#666;
		}
		input{
			height:30px;
			width:150px;
			background-color:#EEE;
			color:#444;
			font-size:14px;
		}
	</style>
  </head>
  
  <body>
  	<table style="border:solid 1px #BBB; align:center; width:900px; cellpadding:10px; cellspacing:5px; background:#DDD;">
  		<tr style="background:#EEE; text-align:left;">
  			<td style="font-size:20px; font-weight:bold;">图书信息</td>
  		</tr>
  		<tr >
  			<td width="40%" bgcolor="#EEE" rowspan="7" style="padding-left:10px;"><div><img alt="书本封面" src="<s:property value="#book.photo_url"/>" style="width:200px; height:220px;"></div></td>
  			<td><span>书&nbsp;名：</span><input type="text" value="<s:property value="#book.bookName"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td><span>作&nbsp;者：</span><input type="text" value="<s:property value="#book.author"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td><span>出版社：</span><input type="text" value="<s:property value="#book.publisher"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td><span>价&nbsp;格：</span><input type="text" value="<s:property value="#book.price"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td><span>复本量：</span><input type="text" value="<s:property value="#book.cnum"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td><span>库存量：</span><input type="text" value="<s:property value="#book.snum"/>" readonly/></td>
  		</tr>
  		<tr>
  			<td style="margin-bottom"><span>简&nbsp;介：</span><input type="text" value="<s:property value="#book.summary"/>" readonly/></td>
  		</tr>
  	</table>
  </body>
</html>


















