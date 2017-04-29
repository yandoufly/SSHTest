<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
<div>
	<div>新闻公告信息</div>
	<c:if test="${not empty requestScope.allMessage }">
		<table border="1">
			<tr>
				<th>主题</th>
				<th>创建时间</th>
				<th>查看</th>
			</tr>
			<c:forEach items="${allMessage }" var="message" varStatus="vs">
					<tr>
						<td>${message.title }</td>
						<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd"/></td>
						<td>
							<form action="main-knowMessage" method="post">
								<input type="hidden" name="id" value="${message.id }">
								<input type="submit" value="查看">
							</form>
						</td>
					</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
<br><br>
<a href="javascript:history.back(1);">返回上一页</a>
</center>
</body>
</html>