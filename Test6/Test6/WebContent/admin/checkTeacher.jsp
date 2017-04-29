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
<div id="MainForm">
	<div class="form_boxB">
	<c:if test="${requestScope.allNoStatusTeachers!=null || fn:length(requestScope.allNoStatusTeachers)!=0}">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>工号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>职类</th>
			<th>电话</th>
			<th>QQ</th>
			<th>详细资料</th>
			<th>激活</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${allNoStatusTeachers }" var="teacher">
			<tr>
				<td>${teacher.teacherId }</td>
				<td>${teacher.name }</td>
				<td>${teacher.sex }</td>
				<td>${teacher.profess }</td>
				<td>${teacher.telephone }</td>
				<td>${teacher.qq }</td>
				<td>
					<form action="admin-lookTeacher" method="post">
						<input type="hidden" name="id" value="${teacher.teacherId }">
						<input type="submit" value="查看">
					</form>
				</td>
				<td>
					<form action="admin-activeTeacher" method="post">
						<input type="hidden" name="id" value="${teacher.teacherId }">
						<input type="submit" value="激活">
					</form>
				</td>
				<td>
					<form action="admin-delTeacher" method="post">
						<input type="hidden" name="id" value="${teacher.id }">
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