<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>

<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
  		<tr>
  			<th>序号</th>
  			<th>主题</th>
  			<th>创建时间</th>
  			<th>详细</th>
  		</tr>
  		<!-- 迭代数据 -->
  		<c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="message" items="${requestScope.pageBean.pageData}" varStatus="vs">
  					<tr>
  						<td>${vs.count }</td>
  						<td>${message.title }</td>
  						<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd"/></td>
  						<td><a href="#">详细</a></td>
  					</tr>
  				</c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="3">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="4" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/main-getmoreMessage?currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/main-getmoreMessage?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="${pageContext.request.contextPath }/main-getmoreMessage?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="${pageContext.request.contextPath }/main-getmoreMessage?currentPage=${requestScope.pageBean.totalPage}">末页</a>
  			</td>
  		</tr>
  		
  	</table>
</body>
</html>