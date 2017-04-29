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
<h3>为用户<font color="blue">${student.sname}</font>添加角色</h3>
<form action="saveRole">
   	<input type="hidden" name="student.sid" value="${student.sid}"/>
   	<!-- 制定为哪个角色添加权限 -->
   	<c:forEach var="roles" items="${roleList}" varStatus="rs">
   	   <c:choose>
   	   		<c:when test="${roles.checked}"><input type="checkbox" name="queryRole[${rs.index}].rid" value="${roles.rid}" checked="checked"/></c:when>
   	   		<c:otherwise><input type="checkbox" name="queryRole[${rs.index}].rid" value="${roles.rid}"/></c:otherwise>
   	   </c:choose>	
   		${roles.roleName}<br/>
   	</c:forEach>
   	<input type="submit" value="提交"/>
</form>
</center>
</body>
</html>