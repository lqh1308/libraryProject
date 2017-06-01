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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="margin:0; padding:0; bgcolor:#DDD">
	  	<table style="margin:auto">
	  		<tr>
	  			<td colspan="2" width="100%" height="200px"><jsp:include page="/otherJsp/head.jsp"></jsp:include></td>
	  		</tr>
	  		<tr>
	  			<td height="600px" width="25%" bgcolor="#EEE" style="padding-left:10px;">
	  			<jsp:include page="manage-left.jsp"></jsp:include>
	  			</td>
	  			<td height="600px" width="75%" bgcolor="#EEE">
	  				<div style="height:10px; width:100%; background:#DDD; margin-top:-290px;">
	  					<p style="margin-top:-3px;">图书ID：&nbsp;<input type="text" size="20">&nbsp;<input type="button" value="借书"></p>
	  				</div>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2" height="40px;"><span style="font-weight:bold;">湖南工业大学</span></td>
	  		</tr>
	  	</table>
  </body>
</html>
