<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'roleModules.jsp' starting page</title>
    
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
    	给角色:<font color="red">${role.roleName} </font>设置功能权限：
    	<hr>
    	<form action="saveRoleModules">
    	
    		<input type="hidden" name="role.rid" value="${role.rid }"/>
    		
	    	<c:forEach var="m" items="${list}" varStatus="dddd">
	    	 <c:choose>
	    	 	<c:when test="${m.checked}"><input type="checkbox" name="list[${dddd.index}].mid" value="${m.mid}" checked="checked"/></c:when>
	    	 	<c:otherwise><input type="checkbox" name="list[${dddd.index}].mid" value="${m.mid}"/></c:otherwise>
	    	 </c:choose>
	    	 ${m.moduleName}<br>
	    	</c:forEach>
	    	<input type="submit"/>
    	</form>
  </body>
</html>
