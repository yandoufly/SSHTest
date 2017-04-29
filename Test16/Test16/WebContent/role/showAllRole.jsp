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
	<h3>角色管理</h3>
	<table>
		<tr><td>角色名字</td><td>操作</td></tr>
  		<c:forEach var="r" items="${list}">
  			<tr>
  				<td>${r.roleName }</td>
  				<td><a href="deleteRole?role.rid=${r.rid}">删除</a> &nbsp;&nbsp;
  					<a href="setRoleModules?role.rid=${r.rid }">设置权限</a></td>
  			</tr>
  		</c:forEach>
	</table>
</center>
</body>
</html>