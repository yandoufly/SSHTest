<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/"; 
%>
<html>
<head>
<base href=" <%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/side.js" type="text/javascript"></script>
</head>

<body>
<!-- wrap_left -->
<jsp:include page="wrap_left.jsp" />


<!-- wrap_right -->
<div class="wrap_right">
<jsp:include page="header.jsp" />
<div id="Contents">
<h2>审核教师发布的新闻公告</h2>
<div id="MainForm">
	<div class="form_boxB">
	<c:if test="${requestScope.allNoDisplayMessage!=null || fn:length(requestScope.allNoDisplayMessage)!=0}">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>主题</th>
				<th>内容</th>
				<th>创建时间</th>
				<th>显示在页面</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${allNoDisplayMessage }" var="message">
				<tr>
					<td>${message.title }</td>
					<td>${message.content }</td>
					<td>${message.createTime }</td>
					<td>
						<form action="admin-activeMessage" method="post">
							<input type="hidden" name="id" value="${message.id }">
							<input type="submit" value="是">
						</form>
					</td>
					<td>
						<form action="admin-delMessage" method="post">
							<input type="hidden" name="id" value="${message.id }">
							<input type="submit" value="删除">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
</div>
</div>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>