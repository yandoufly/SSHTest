<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllQuestion.jsp' starting page</title>
    
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
   	 以下是所有题目及答案
   	 <hr>
   	 <table width="50%">
   	 <tr><td>题目编号</td><td>内容</td><td>操作</td></tr>
   	 <c:forEach var = "q" items="${list}">
   	 	<tr><td>${q.qid}:</td><td>${q.content}</td><td><a href="deleteQuestion?question.qid=${q.qid}">删除</a><a href="showQuestionInfo?question.qid=${q.qid }">修改</a></td></tr>
   	 	<tr><td></td><td>
   	 	<c:forEach var="o" items="${q.options}">
   	 	<c:choose>
   	 			<c:when test="${o.yes}"><font color="red">${o.mark}.&nbsp;${o.content}</font></c:when>
   	 			<c:otherwise>${o.mark}.&nbsp;${o.content}</c:otherwise>
   	 		</c:choose>
   	 	</c:forEach>
   	 	</td><td></td></tr>
   	 </c:forEach>
   	 </table>
   	 <hr/>
   	 <!-- 动态显示分页的超链接 -->
   	 第
   	 <% 
   	 	//一共多少条数据呢?
   	 	long count = (Long)request.getAttribute("count");
   	 	//每页显示多少条数据呢? 5 条
   	 	//一共有多少页
   	 	int pages = (int)((count+4)/5);
   	 	
   	 	for(int i=1;i<=pages;i++){
   	 		out.print("&nbsp;<a href='showAllQuestion?begin="+(i-1)*5+"'>"+i+"</a>&nbsp;");
   	 	}
   	  %>
   	  页
  </body>
</html>
