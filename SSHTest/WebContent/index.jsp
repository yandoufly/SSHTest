<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="emp-list">List All Employees</a>
	
	<br><br>
	
	<a href="emp-input">Add New Employee</a>
	
	<br><br>
	<h3>登录页面</h3>
	<form action="emp-login" method="post">
		用户名:<input type="text" name="employee.lastName"><br><br>
		密码:<input type="text" name="employee.password"><br><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>