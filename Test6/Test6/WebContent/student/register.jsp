<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册</title>
</head>
<body>
${msg } <br>
<form action="student_register" method="post">
	学好：<input type="text" name="student.studentId" value="1300310226"><br> 
	姓名：<input type="text" name="student.name" value="严景云"><br> 
	密码：<input type="password" name="student.passwd" value="123"><br> 
	性别：<input type="text" name="student.sex" value="男"><br> 
	出生：<input type="text" name="student.birthday" value="1994-5-10"><br> 
	学院：<input type="text" name="student.dept" value="计算机科学与信息安全学院"><br> 
	专业：<input type="text" name="student.profess" value="计算机科学与技术"><br> 
	电话：<input type="text" name="student.telephone" value="13100536560"><br> 
	QQ：<input type="text" name="student.qq" value="326015540"><br> 
	<input type="submit" value="提交"><br>
</form>
</body>
</html>