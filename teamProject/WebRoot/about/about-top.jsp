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
  	<table style="paddin:0; margin:auto; width:100%;">
  		<tr>
  			<td width="20%" height="600px" style="text-align:left;">
  				<div style="width:100%; height:100%; background:#FFF;">
  					<img style="magin-left:50px;" src="image/lib2.gif"></img>
  					<img style="margin-top:50px;" src="image/lib3.jpg"></img>
  					<p style="color:gray">湖南工业大学图书馆</p>
  					<ul style="margin-top:60px; color:gray; list-style:none; margin-left:-13px;">
  						<li><span style="color:#FC5">中文名</span>&nbsp;湖南工业大学图书馆</li>
  						<li><span style="color:#FC5">藏书</span>&nbsp;&nbsp;300多万册</li>
  						<li><span style="color:#FC5">始建于</span>&nbsp;1979年</li>
  						<li><span style="color:#FC5">面积</span>&nbsp;&nbsp;34500平方米</li>
  					</ul>
  				</div>
  			</td>
  			<td width="80%" height="600px" style="text-align:left;">
	  			<div style="width:100%; height:100%; background:#DDD;">
		  			<p style="font-size:20px; font-weight:bold; margin-left:40px;">图书馆简介</p>
		  			<blockquote style="color:dark-gray; font-size:16px;">&nbsp;&nbsp;<a name="introdece" id="introduce">目前，</a>包括校本部和新校区两个分馆，新图书馆面积34500平方米，是湖南省高校中最大的图书馆之一，于2013年9月新学期正式启用。藏书300多万册，其中纸本藏书200多万册，电子图书43.68万册。
		  			<br><br>&nbsp;&nbsp;1997年，图书馆引进了先进的图书馆自动化管理系统——Ilas图书馆集成管理系统，图书馆所有业务工作均实行了自动化管理。2001年，图书馆启动了数字化资源的建设。目前，图书馆拥有的数字资源容量超过10T，可以使用的数据库包括中国知网、超星数字图书馆、万方数据库系统等60多个，并与湖南省高校数字化图书馆实现了资源的共建共享。
		  			<br><br>&nbsp;&nbsp;网络方面计划：图书馆建有主干光纤千兆上连校园网、桌面百兆、技术先进、统一管理的局域网系统和存储网络系统，拥有服务器7台、计算机261台，全部业务与服务均实现了网上自动化、数字化。
		  			<br><br>&nbsp;&nbsp;开放及管理计划：图书馆每周开放6天，每周开放93.5小时，网络及数字资源全天24小时开放。所有书库和阅览室对读者实行全开架服务，开架借阅率达到100%。
		  			<br><br>&nbsp;&nbsp;服务方面计划：提供文献外借、参考咨询、代查代检、文献传递、馆际互借、文献复制、书目查询、新书荐购、读者信息查询、新书通报、网上书刊预约、催还和续借、网络数据库检索及全文下载、光盘数据库检索、虚拟咨询与答疑、网上视频点播和网上报告厅播放等多项服务。</blockquote>
		  			
		  			<p style="font-size:20px; font-weight:bold; margin-left:40px; margin-top:50px;">开放时间</p>
		  			<blockquote style="color:dark-gray; font-size:16px;">&nbsp;&nbsp;<a name="time" id="time">周一-周四：8:00-22:00</a>
		  			<br>&nbsp;&nbsp;周五：&nbsp;&nbsp;闭馆。
		  			<br>&nbsp;&nbsp;周六-周日：8:00-22:00</blockquote>
	  			</div>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
