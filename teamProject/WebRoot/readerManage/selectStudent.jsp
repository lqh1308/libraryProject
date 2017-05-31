<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'selectStudent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="margin: 300px">
	<s:form theme="simple" action="selectStudent" method="post">
		<s:set name="stu" value="#request.stu"></s:set>
		<s:if test="#stu != null">
		<table
			style="align:center; width:900px; cellpadding:10px; cellspacing:5px; background:#EEE; 
					  			margin-top:-255px; width:400px;">
			<tr>
				<td style="height:50px;">ReaderId：&nbsp;</td>
				<td><s:property value="#stu.readerId" /></td>
			</tr>
			<tr>
				<td style="height:50px;">姓&nbsp;&nbsp;名：&nbsp;</td>
				<td><s:property value="#stu.name"/></td>
			</tr>
			<tr>
				<td style="height:50px;"><span>性&nbsp;&nbsp;别：&nbsp;</span></td>
				<td><s:property value="#stu.sex"/></td>
			</tr>
			<tr>
				<td style="height:50px;">出生年月：&nbsp;</td>
				<td><s:property value="#stu.born"/></td>
			</tr>
			<tr>
				<td style="height:50px;">专&nbsp;&nbsp;业：&nbsp;</td>
				<td><s:property value="#stu.spec"/></td>
			</tr>
		</table>
		</s:if>
		<s:else>
		<span style="color:red"><s:property value="message" /> </span>
		<table style="margin-left:100px; margin-top:-200px;">
			<tr>
					<s:fielderror></s:fielderror>
					<s:property value="message"/><br>
			</tr>
			<tr>
				读者ID ：<s:textfield name="student.readerId" />
			</tr>
			<tr>
				<s:submit
					style="margin-left:10px; margin-top:-200px; height:30px; width:50px;"
					value="查询" method="selectStudent" />
			</tr>
		</table>
		</s:else>
	</s:form>
</body>
</html>
