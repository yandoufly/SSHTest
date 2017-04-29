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
<h3>以下是等待我要考的考试</h3>
<table>
	<tr><td>考试名称</td><td>考试时间</td><td>考试总分</td><td>考试体量</td><td>操作</td></tr>
	<c:forEach var="e" items="${list}">
	<tr>
		<td>${e.examName }</td>
		<td>${e.examTime }</td>
		<td>${e.examTotalScore }</td>
		<td>${e.examQuestionCount }</td>
		<td><a href="createExamPaper?exam.examId=${e.examId }">生成试卷</a></td>
	</tr>
	</c:forEach>
</table>
		
</center>
</body>
</html>