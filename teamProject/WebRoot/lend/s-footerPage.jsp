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

  </head>
  
  <body>
  	<table>
  		<tr>
  			<td align="right">
  				<a href="s_selectBook.action?pageNow=1&lend.readerId=<s:property value="#request.readerId"/>">首页</a>
  				<s:if test = "#request.page.isHasPre()">
  					<a href="s_selectBook.action?pageNow=<s:property value="#request.page.pageNow-1"/>&lend.readerId=<s:property value="#request.readerId"/>">上一页</a>
  				</s:if>
  				<s:else>
  					<a href="s_selectBook.action?pageNow=1&lend.readerId=<s:property value="#request.readerId"/>">上一页</a>
  				</s:else>
  				<s:if test = "#request.page.isHasNext()">
  					<a href="s_selectBook.action?pageNow=<s:property value="#request.page.pageNow+1"/>&lend.readerId=<s:property value="#request.readerId"/>">下一页</a>
  				</s:if>
  				<s:else>
  					<a href="s_selectBook.action?pageNow=<s:property value="#request.page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/>">下一页</a>
  				</s:else>
  				<a href="s_selectBook.action?pageNow=<s:property value="#request.page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/>">尾页</a>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
