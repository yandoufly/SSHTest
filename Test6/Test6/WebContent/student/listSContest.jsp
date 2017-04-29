<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<table border="1">
	<tr>
		<td>编号</td>
		<td>参加竞赛的名称</td>
		<td>几等奖</td>
	</tr>
	<c:forEach items="${listSContest }" var="SContest" varStatus="vs">
	<tr>
		<td>${vs.index+1}</td>
		<td>${SContest.contest.title }</td>
		<td>${SContest.rank }</td>
	</tr>
	</c:forEach>
</table>
</center>
</body>
</html>