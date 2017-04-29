<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<div>提示信息：${msg }</div>
<div>欢迎 &nbsp; ${teacher.name } &nbsp; 老师登录竞赛网站</div>
<div>
	<a href="${pageContext.request.contextPath }/teacher/addContest.jsp">发布竞赛</a>
	&nbsp; | &nbsp;
	<a href="${pageContext.request.contextPath }/teacher/addMessage.jsp">发布公告</a>
	&nbsp; | &nbsp;
	<a href="teacher_getAllContest">查看参加学生竞赛信息</a><br>
</div>
</center>
</body>
</html>