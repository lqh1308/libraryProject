<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>图书管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var fun1 = function(path) {
			var mif = document.getElementById("myiframe");
			mif.src = '<%=basePath%>' + 'readerManage/' + path;
		};
		
    function getIframeWindow(obj) {  
        return obj.contentWindow || obj.contentDocument.parentWindow;  
    }  
    function getIframeHeight(obj){  
        var idoc = getIframeWindow(obj).document;   
        if(idoc.body){  
            return Math.max(idoc.body.scrollHeight,idoc.body.offsetHeight);     
        }else if(idoc.documentElement){  
            return Math.max(idoc.documentElement.scrollHeight,idoc.documentElement.offsetHeight);     
        }  
    }  
    function setHeight(){     
        var myiframe = document.getElementById("myiframe");  
        myiframe.height = getIframeHeight(myiframe);  
    }
	</script>
</head>

<body style="margin:0; padding:0; bgcolor:#DDD">
	<table style="margin:auto; width:1250px;">
		<tr>
			<td colspan="2" width="100%" height="200px"><jsp:include
					page="/otherJsp/head.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td height="600px" width="25%" bgcolor="#EEE">
				<table style="margin-top:9px" width="100%" cellspacing=1
					class="font1">
					<tr bgcolor="#DDD">
						<td style="height:50px;"><span
							style="font-size:20px; font-weight:bold; font-color:#444;">功能选择</span>
						</td>
						<br>
						<span style="color:red"><s:property value="message" /> </span>
					</tr>
					<tr>
						<td align="center" valign="top" height="500"><br>
							<input type="button" value="用户注册" onclick="fun1('addStudent.jsp')" style="height:30px; width:100px; color:#666"></input>
							<br> <br>
							<input type="button" value="用户删除" onclick="fun1('deleteStudent.jsp')" style="height:30px; width:100px; color:#666"></input>
							<br> <br>
							<input type="button" value="用户修改" onclick="fun1('updateStudent.jsp')" style="height:30px; width:100px; color:#666"></input>
							<br> <br>
							<input type="button" value="用户查询" onclick="fun1('selectStudent.jsp')" style="height:30px; width:100px; color:#666"></input>
							<br>
						</td>
					</tr>
				</table></td>
			<td height="600px" width="75%" bgcolor="#EEE">
				<iframe id="myiframe" onload="setHeight()" src="<%=basePath%>/welcome/main.jsp" frameborder="0" style="width: 100%; height: 100%" ></iframe>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="40px;"><span style="font-weight:bold;">湖南工业大学</span>
			</td>
		</tr>
	</table>
</body>
</html>
