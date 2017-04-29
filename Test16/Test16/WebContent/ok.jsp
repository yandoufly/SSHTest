<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="zx" uri="com.yjy.mytag.core" %>
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
<div>欢迎 ${user.sname } 登录系统</div>
<div >
	<zx:show whatAreYoudoing="userManage">
	    <div>
			<h3>用户管理</h3>
			<a href="addStudentPage">添加用户</a><br>
		</div>
	</zx:show>
	
	<zx:show whatAreYoudoing="priManage">
		<div>
			<h3>权限管理</h3>
			<a href="addRolePage">添加角色</a><br>
		  	<a href="showAllRole">设置角色权限</a><br>
		  	<a href="showAllUser">设置用户角色</a><br>
		</div>
	</zx:show>
	
	<zx:show whatAreYoudoing="questionManage">
		<div>
			<h3>题库管理</h3>
			<a href="addQuestionPage">添加考题</a><br>
			<a href="showPageQuestion">查询考题</a><br>
		</div>
	</zx:show>
	
	<zx:show whatAreYoudoing="paperManage">
		<div>
			<h3>试卷管理</h3>
			<a href="newExamPage">发布考试</a><br>
		</div>
	</zx:show>
	
	<zx:show whatAreYoudoing="examManage">
		<div>
			<h3>考试管理</h3>
			<a href="showAllExam">我的考试</a><br>
			<a href="showMyPaper">我的试卷</a><br>
		</div>  
	</zx:show>
</div>

</body>
</html>