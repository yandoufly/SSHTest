<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师注册</title>
</head>
<body>
<center>
${msg }<br>
<form action="teacher_register" method="post">
	工号：<input type="text" name="teacher.teacherId" value="1001"><br>
	姓名：<input type="text" name="teacher.name" value="老师1"><br>
	密码：<input type="text" name="teacher.passwd" value="123"><br>
	性别：<input type="text" name="teacher.sex" value="男"><br>
	出生：<input type="text" name="teacher.birthday" value="1986-5-12"><br>
	职类：
		<select name="teacher.profess">
			<option value="学院教师">学院教师</option>
			<option value="教务处教师">教务处教师</option>
		</select><br>
	电话：<input type="text" name="teacher.telephone" value="18799361526"><br>
	QQ：<input type="text" name="teacher.qq" value="66666666"><br>
	微信：<input type="text" name="teacher.weixin" value="doffly"><br>
	个人简介：<input type="text" name="teacher.profiles" value="我不是大神，我爱编程!!!"><br>
	<input type="submit" value="提交"><br>
</form>
</center>
</body>
</html>