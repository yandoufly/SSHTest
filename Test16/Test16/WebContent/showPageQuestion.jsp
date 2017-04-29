<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
	以下是所有题目及答案
   	 <hr>
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
  		<tr><td>编号</td><td>内容</td><td>操作</td></tr>
  		<!-- 迭代数据 -->
  		<c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="question" items="${requestScope.pageBean.pageData}" varStatus="vs">
  					<tr>
  						<td>${vs.count }</td>
  						<td>${question.content }</td>
  						<td>
  							<a href="deleteQuestion?question.qid=${question.qid}">删除</a>
  							<a href="showQuestionInfo?question.qid=${question.qid }">修改</a>
  						</td>
  					</tr>
  					<tr><td colspan="3">
  						选项：
				   	 	<c:forEach var="o" items="${question.options}">
				   	 		<c:choose>
				   	 			<c:when test="${o.yes}"><font color="red">${o.mark}.&nbsp;${o.content}</font></c:when>
				   	 			<c:otherwise>${o.mark}.&nbsp;${o.content}</c:otherwise>
				   	 		</c:choose>
				   	 		&nbsp;&nbsp;
				   	 	</c:forEach>
			   	 	</td></tr>
  				</c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="3">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="7" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/showPageQuestion?currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/showPageQuestion?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="${pageContext.request.contextPath }/showPageQuestion?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="${pageContext.request.contextPath }/showPageQuestion?currentPage=${requestScope.pageBean.totalPage}">末页</a>
  			</td>
  		</tr>
  		
  	</table>
</center>
</body>
</html>