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
<h3>以下是我的试卷</h3>
<table>
   	<tr>
    	<td>试卷编号</td>
    	<td>试卷名称</td>
    	<td>总分</td>
    	<td>考试时间</td>
    	<td>题目数量</td>
    	<td>开始时间</td>
    	<td>交卷时间</td>
    	<td>试卷状态</td>
    	<td>试卷得分</td>
    	<td>操作</td>
   	</tr>
   	<c:forEach var="p" items="${list}">
   	<tr>
    	<td>${p.epId}</td>
    	<td>${p.exam.examName}</td>
    	<td>${p.exam.examTotalScore }</td>
    	<td>${p.exam.examTime}</td>
    	<td>${p.exam.examQuestionCount}</td>
    	<td>${p.startTime}</td>
    	<td>${p.commitTime}</td>
    	<td>${p.state}</td>
    	<td>${p.score}</td>
    	<td>
    	<c:if test="${p.state=='待考'}"><a href="beginDoQuestion?paperId=${p.epId}">开始考试</a></c:if>
    	<c:if test="${p.state=='考试中'}"><a href="beginDoQuestion?paperId=${p.epId}">继续考试</a></c:if>
    	<c:if test="${p.state=='已完成'}"><a href="beginDoQuestion?paperId=${p.epId}">核对成绩</a></c:if>
    	</td>
   	</tr>
   	</c:forEach>
</table>
</center>
</body>
</html>