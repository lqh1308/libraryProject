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

<title>My JSP 'deleteStudent.jsp' starting page</title>

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
	<s:form theme="simple" action="deleteStudent" method="post">
		<span style="color:red"><s:property value="message" /> </span>
		<table>
			<tr>
					<s:fielderror></s:fielderror><br>
					<s:property value="message"/><br>
			</tr>
			<tr>读者ID:<s:textfield name="student.readerId" />
			</tr>
			<tr>
					<s:submit value="删除" method="deleteStudent" />
			</tr>
		</table>
	</s:form>
</body>
</html>
