<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>为用户分配角色</h3>
<table>
	<tr>
		<td>用户</td>
		<td>操作</td>
	</tr>
	<c:forEach var="student" items="${students}">
		<tr><td>${student.sname}</td>
			<td><a href="setRole?student.sid=${student.sid}">设置角色</a></td>
		</tr>
	</c:forEach>
</table>
</center>
</body>
</html>