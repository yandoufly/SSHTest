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
<script type="text/javascript" src="ckeditor/ckeditor.js"></script> 
<title></title>
</head>
<body>
<center>
	<form action="MessageAction" method="post">
		主题： <input type="text" name="message.title"><br>
		内容： <textarea name="message.content"></textarea>
			 	<script type="text/javascript">CKEDITOR.replace('message.content');</script><br>
		<input type="hidden" name="message.isDisplay" value="0">
		<input type="submit" value="提交"><br>
	</form>
</center>
</body>
</html>