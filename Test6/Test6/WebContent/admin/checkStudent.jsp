<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
	<div id="MainForm">
	<div class="form_boxB">
	<c:if test="${requestScope.allNoStatusStudents!=null || fn:length(requestScope.allNoStatusStudents)!=0}">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生</td>
				<td>学院</td>
				<td>专业</td>
				<td>电话</td>
				<td>QQ</td>
				<td>激活</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${allNoStatusStudents }" var="student">
				<tr>
					<td>${student.studentId }</td>
					<td>${student.name }</td>
					<td>${student.sex }</td>
					<td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/></td>
					<td>${student.dept }</td>
					<td>${student.profess }</td>
					<td>${student.telephone }</td>
					<td>${student.qq }</td>
					<td>
						<form action="admin-activeStudent" method="post">
							<input type="hidden" name="id" value="${student.studentId }">
							<input type="submit" value="激活">
						</form>
					</td>
					<td>
						<form action="admin-delStudent" method="post">
							<input type="hidden" name="id" value="${student.id }">
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