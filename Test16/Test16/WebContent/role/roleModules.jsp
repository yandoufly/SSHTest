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
	<h3>给角色:<font color="red">${role.roleName}</font>设置功能权限：</h3>
   	<form action="saveRoleModules">
   		<input type="hidden" name="role.rid" value="${role.rid }"/>
    	<c:forEach var="m" items="${list}" varStatus="dddd">
	    	 <c:choose>
	    	 	<c:when test="${m.checked}">
	    	 		<input type="checkbox" name="list[${dddd.index}].mid" value="${m.mid}" checked="checked"/>
	    	 	</c:when>
	    	 	<c:otherwise><input type="checkbox" name="list[${dddd.index}].mid" value="${m.mid}"/></c:otherwise>
	    	 </c:choose>
    		 ${m.moduleName}<br>
    	</c:forEach>
    	<input type="submit" value="提交"/>
   	</form>
</center>
</body>
</html>