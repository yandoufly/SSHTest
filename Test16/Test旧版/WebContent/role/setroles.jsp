<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setmodules.jsp' starting page</title>
    
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
    	为用户<font color="blue">${student.sname}</font>添加角色<br/>
    	<form action="saveRole">
	    	<input type="hidden" name="student.sid" value="${student.sid}"/><!-- 制定为哪个角色添加权限 -->
	    	<c:forEach var="roles" items="${roleList}" varStatus="rs">
	    	   <c:choose>
	    	   	<c:when test="${roles.checked}"><input type="checkbox" name="queryRole[${rs.index}].rid" value="${roles.rid}" checked="checked"/></c:when>
	    	   	<c:otherwise><input type="checkbox" name="queryRole[${rs.index}].rid" value="${roles.rid}"/></c:otherwise>
	    	   </c:choose>	
	    		${roles.roleName}<br/>
	    	</c:forEach>
	    	<input type="submit" value="提交"/>
    	</form>
  </body>
</html>
