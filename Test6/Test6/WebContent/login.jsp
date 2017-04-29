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
</head>
<body>
<center>
	<div>${msg }</div>
	<form action="LoginAction" method="post">
		账号:<input type="text" name="id"><br><br>
		密码:<input type="password" name="passwd"><br><br>
		管理员<input type="radio" name="type" value="0"> &nbsp;&nbsp;
		教师<input type="radio" name="type" value="1"> &nbsp;&nbsp;
		学生<input type="radio" name="type" value="2"> &nbsp;&nbsp;
		<br><br>
		<input type="submit" value="提交"><br>
	</form>
</center>
</body>
</html>