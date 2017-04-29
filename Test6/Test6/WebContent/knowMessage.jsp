<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/"; 
%>
<html>
<head>
<base href=" <%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script> 
</head>
<body>
<center>
	主题：<input type="text" value="${message.title }"><br>
	内容：
	<textarea name="message.content">${message.content }</textarea>
	<script type="text/javascript">CKEDITOR.replace('message.content');</script><br>
	<a href="javascript:history.back(1);">返回上一页</a>
</center>
</body>
</html>