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
    
    <title>My JSP 'lendCheck.jsp' starting page</title>
    
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
	  	<table style="margin:auto; width:1250px;">
	  		<tr>
	  			<td colspan="2" width="100%" height="200px"><jsp:include page="/otherJsp/head.jsp"></jsp:include></td>
	  		</tr>
	  		<tr>
	  			<td height="600px" width="25%" bgcolor="#EEE" rowspan="4" style="padding-left:10px;">
	  			</td>
	  			<td height="20px" width="75%" bgcolor="#EEE"></td>
	  		</tr>
	  	</table>
  </body>
</html>
