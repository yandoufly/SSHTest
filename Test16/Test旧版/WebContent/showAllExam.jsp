<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllExam.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	以下是等待我要考的考试
    	<hr>
    	<table>
    	<tr><td>考试名称</td><td>考试时间</td><td>考试总分</td><td>考试体量</td><td>操作</td></tr>
    	<c:forEach var="e" items="${list}">
    	<tr><td>${e.examName }</td><td>${e.examTime }</td><td>${e.examTotalScore }</td><td>${e.examQuestionCount }</td><td><a href="createExamPaper?exam.examId=${e.examId }">生成试卷</a></td></tr>
    	</c:forEach>
    	</table>
    	
  </body>
</html>
