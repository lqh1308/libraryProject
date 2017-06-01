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
	  		<tr style="align:center;" >
    			<td style="color:red"><s:property value="message"/></td>
    		</tr>
	  		<tr>
	  			<td height="600px" width="30%" bgcolor="#EEE" rowspan="2">
	  				<jsp:include page="/returnBook/s-return-left.jsp"></jsp:include>
	  			</td>
	  			<td height="600px" width="70%" bgcolor="#EEE" valign="top">
	  				<jsp:include page="/returnBook/returnBookInfo.jsp"></jsp:include>
	  			</td>
	  		</tr>
	  		<tr style="align:center;" >
	  			<td align="right" height="30px" width="75%" bgcolor="#EEE">
	  				<jsp:include page="/returnBook/s-footerPage.jsp"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2" height="40px;"><span style="font-weight:bold;">湖南工业大学</span></td>
	  		</tr>
	  	</table>
  </body>
</html>
