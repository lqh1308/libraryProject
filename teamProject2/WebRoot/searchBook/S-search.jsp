<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书查询系统</title>
    
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
	  			<td colspan="2" width="100%" height="200px"><jsp:include page="/otherJsp/headStu.jsp"></jsp:include></td>
	  		</tr>
	  		<tr>
	  			<td height="590px" width="25%" bgcolor="#EEE" rowspan="3" style="padding-left:10px;">
	  			<jsp:include page="/searchBook/s-search-left.jsp"></jsp:include>
	  			</td>
	  			<td height="20px" width="75%" bgcolor="#EEE"></td>
	  		</tr>
	  		<tr align="center">
	  			<td height="540px" width="75%" bgcolor="#EEE" valign="top" >
	  				<jsp:include page="/searchBook/showBookInfo.jsp"></jsp:include>
	  			</td>
	  		</tr>
	  		<tr align="center">
	  			<td width="75%" bgcolor="#EEE">
	  				<font color="red"><s:property value="message"/></font>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2" height="40px;"><span style="font-weight:bold;">湖南工业大学</span></td>
	  		</tr>
	  	</table>
  </body>
</html>
