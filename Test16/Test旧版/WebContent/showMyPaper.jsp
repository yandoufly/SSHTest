<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMyPaper.jsp' starting page</title>
    
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
           以下是我的试卷
    <hr>
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
  </body>
</html>
