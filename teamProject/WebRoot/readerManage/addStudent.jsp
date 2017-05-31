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

<title>My JSP 'addStudent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="margin-top: 300px">

	<s:form theme="simple" action="addStudent" method="post" validate="true">
		<table
			style="align:center; width:900px; cellpadding:10px; cellspacing:5px; background:#EEE; 
		margin-top:-255px; width:400px;">
			<tr>
				<td style="height:50px;"></td>
				<td>
					<s:fielderror></s:fielderror>
					<s:property value="message"/><br>
				</td>
			</tr>
			<tr>
				<td style="height:50px;">ReaderId：&nbsp;</td>
				<td><s:textfield name="student.readerId" />
				</td>
			</tr>
			<tr>
				<td style="height:50px;">姓&nbsp;&nbsp;名：&nbsp;</td>
				<td><s:textfield name="student.name" />
				</td>
			</tr>
			<tr>
				<td style="height:50px;"><span>性&nbsp;&nbsp;别：&nbsp;</span></td>
				<td><s:select name="student.sex" list="{'男','女'}" style="width:50px;"
						harderkey='-1' harderValue="男" multiple="false" />
				</td>
			</tr>
			<tr>
				<td style="height:50px;">出生年月：&nbsp;</td>
				<td><s:textfield name="student.born" />
				</td>
			</tr>
			<tr>
				<td style="height:50px;">专&nbsp;&nbsp;业：&nbsp;</td>
				<td><s:textfield name="student.spec" /></td>
			</tr>
			<tr>
				<td style="height:50px;"></td>
				<td><s:submit style="height:40px; width:50px; margin-top:-160px; margin-left:100px;" value="录入" method="addStudent" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
