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
    
    <title>My JSP 'manage-left.jsp' starting page</title>
    
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
  	<table  style="margin-top:-365px;">
  		<tr> 
  			<td><div style="backgrond:#DDD; width:280px; font-weight:bold; height:15px;">功能选择</div></td>
  			<td>
  				<span style="align:center;"><s:submit vlaue="增加图书"/><br></span>
  				<s:submit vlaue="删除图书"/><br>
  				<s:submit vlaue="修改图书"/><br>
  				<s:submit vlaue="查询图书"/><br>
  			</td>
  		</tr>
  	</table>
  </body>
</html>





