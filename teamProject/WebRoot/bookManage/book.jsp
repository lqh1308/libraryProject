<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.font1{font-size:13px;}
	</style>
	<script language="javascript">
	//function myfunction(v) {
		//document.all['image'].src="";
		//console.log('haha');
	//}
	function check(thisObject){
		var sTmp="";
		sTmp=thisObject.value;
		if(isNaN(sTmp)){
			thisObject.text("请输入数字");
			thisObject.select();
		}
	}
	</script>
	
	<style>
		span{
			font-size:17px;
			font-weight:bold;
			color:#666;
		}
		input{
			height:30px;
			width:150px;
			background-color:#EEE;
			color:#444;
			font-size:14px;
		}
		textarea{
			height:30px;
			width:150px;
			background-color:#EEE;
			color:#444;
			font-size:14px;
		}
	</style>

  </head>
  
  <body style="margin:0; padding:0; bgcolor:#DDD">
	  	<table style="margin:auto; width:1250px;">
	  		<tr>
	  			<td colspan="2" width="100%" height="200px"><jsp:include page="/otherJsp/head.jsp"></jsp:include></td>
	  		</tr>
	  		<tr>
	  		<s:form theme="simple" action="book" method="post" enctype="multipart/form-data" validate="true">
	  			<td height="600px" width="25%" bgcolor="#EEE">
					<table style="margin-top:9px" width="100%" cellspacing=1 class="font1">
						<tr bgcolor="#DDD">
							<td style="height:50px;"><span style="font-size:20px; font-weight:bold; font-color:#444;">功能选择</span></td>
						</tr>
						<tr>
							<td align="center" valign="top" height="500">
								<br><s:submit value="图书追加" method="addBook" style="height:30px; width:100px; color:#666"/><br>
								<br><s:submit value="图书删除" method="deleteBook" style="height:30px; width:100px; color:#666"/><br>
								<br><s:submit value="图书修改" method="updateBook" style="height:30px; width:100px; color:#666"/><br>
								<br><s:submit value="图书查询" method="selectBook" style="height:30px; width:100px; color:#666"/><br>
							</td>
						</tr>
					</table>
				</td>
	  			<td height="600px" width="75%" bgcolor="#EEE">
	  				<table width="100%" cellspacing="1" class="font1">
	  					<tr style="background:#EEE; text-align:left;">
  							<td style="font-size:20px; font-weight:bold;">图书信息</td>
  						</tr>
						<tr>
							<td height="600px" valign="top"><br>
								<s:if test="#request.onebook==null">
								<table style="border:solid 1px #BBB; align:center; width:900px; height:500px; cellpadding:10px; cellspacing:5px; background:#DDD;">
							  		<tr >
							  			<td width="40%" bgcolor="#EEE" rowspan="10" style="padding-left:10px;"><div style="width:200px; height:220px; margin-left:65px; margin-top:-130px;">
							  			<s:file name="photo" accept="image/*"/></div></td>
							  			<td height="30px" align="center">
											<font color="red"><s:property value="message"/></font>
										</td>
							  		</tr>
									<tr>
										<td>
											<font color="red"><s:fielderror/></font>
										</td>
									</tr>
							  		<tr>
							  			<td><span>ISBN&nbsp;：</span><input type="text" value="" name="book.ISBN"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>书&nbsp;名：</span><input type="text" value="" name="book.bookName"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>作&nbsp;者：</span><input type="text" value="" name="book.author"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>出版社：</span><input type="text" value="" name="book.publisher"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>价&nbsp;格：</span><input type="text" value="" name="book.price" onblur="check(this)"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>复本量：</span><input type="text" value="" name="book.cnum" onblur="check(this)"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>库存量：</span><input type="text" value="" name="book.snum" disabled/></td>
							  		</tr>
							  		<tr>
							  			<td style="margin-bottom"><span style="margin-left:5px;">简&nbsp;介：</span><textarea name="onebook.summay"></textarea></td>
							  		</tr>
							  	</table>
								</s:if>
								<s:else>
								<s:set name="onebook" value="#request.onebook"/>
								<table style="border:solid 1px #BBB; align:center; width:900px; height:500px; cellpadding:10px; cellspacing:5px; background:#DDD;">
							  		<tr >
							  			<td width="40%" bgcolor="#EEE" rowspan="10" style="padding-left:10px;"><div style="width:200px; height:220px; margin-left:65px;">
							  			<s:file name="photo" accept="image/*"/></div></td>
							  			<td align="center">
											<font color="red"><s:property value="message"/></font>
										</td>
							  		</tr>
									<tr>
										<td>
											<font color="red"><s:fielderror/></font>
										</td>
									</tr>
							  		<tr>
							  			<td><span>ISBN&nbsp;：</span><input type="text" value="<s:property value="#onebook.ISBN"/>" 
							  			name="onebook.ISBN" readonly/></td>
							  		</tr>
							  		<tr>
							  			<td><span>书&nbsp;名：</span><input type="text" value="<s:property value="#onebook.bookName"/>" 
							  			name="onebook.bookName"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>作&nbsp;者：</span><input type="text" value="<s:property value="#onebook.author"/>"
							  			 name="onebook.author"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>出版社：</span><input type="text" value="<s:property value="#onebook.publisher"/>" 
							  			name="onebook.publisher"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>价&nbsp;格：</span><input type="text" value="<s:property value="#onebook.price"/>" 
							  			name="onebook.price" onblur="check(this)"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>复本量：</span><input type="text" value="<s:property value="#onebook.cnum"/>" 
							  			name="onebook.cnum" onblur="check(this)"/></td>
							  		</tr>
							  		<tr>
							  			<td><span>库存量：</span><input type="text" value="<s:property value="#onebook.snum"/>" 
							  			name="onebook.snum" onblur="check(this)" disabled/></td>
							  		</tr>
							  		<tr>
							  			<td style="margin-bottom"><span>简&nbsp;&nbsp;介：</span><textarea name="onebook.summay"><s:property value="#onebook.ISBN"/></textarea></td>
							  		</tr>
							  	</table>
								</s:else>
							</td>
						</tr>
					</table>
				</td>
	  		</s:form>
	  		</tr>
	  		<tr>
	  			<td colspan="2" height="40px;"><span style="font-weight:bold;">湖南工业大学</span></td>
	  		</tr>
	  	</table>
  </body>
</html>
