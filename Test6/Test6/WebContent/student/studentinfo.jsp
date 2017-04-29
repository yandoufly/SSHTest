<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
<div>提示信息：${msg }</div>
<div>欢迎 ：${student.name } 登录竞赛信息系统</div><br>
<div>
	<a href="${pageContext.request.contextPath }/student_returnMainFrame">主页</a>
	&nbsp;&nbsp; | &nbsp;&nbsp; 
	<a href="${pageContext.request.contextPath }/student/studentinfo.jsp">查看个人信息</a>
	&nbsp;&nbsp; | &nbsp;&nbsp; 
	<a href="student_getAllSContest?studentId=${student.studentId }">查看已参加的竞赛</a><br>
</div>
<br><br><br>
<form action="student_updateStudent">
	<input type="hidden" name="student.status" value="${student.status }">
	<input type="hidden" name="student.id" value="${student.id }">
	学好： <input type="text" name="student.studentId" value="${student.studentId }" readonly="readonly"><br>
	姓名 ：<input type="text" name="student.name" value="${student.name }"><br>
	密码 ：<input type="text" name="student.passwd" value="${student.passwd }"><br>
	性别：<input type="text" name="student.sex" value="${student.sex }"><br>
	出生：<input type="text" name="student.birthday" value="<fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd"/>"><br>
	学院： <input type="text" name="student.dept" value="${student.dept }"><br>
	专业： <input type="text" name="student.profess" value="${student.profess }"><br>
	电话：<input type="text" name="student.telephone" value="${student.telephone }"><br>
	QQ: <input type="text" name="student.qq" value="${student.qq }"><br>
	<input type="submit" value="修改个人信息"><br>
</form>
</center>
</body>
</html>