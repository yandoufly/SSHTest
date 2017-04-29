<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/style/exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("userName").value;
		var password=document.getElementById("password").value;
		if(userName==null || userName==""){
			alert("用户名不能为空！");
			return false;
		}
		if(password==null || password==""){
			alert("密码不能为空！");
			return false;
		}
		return true;
	}

	function resetValue(){
		document.getElementById("userName").value="";
		document.getElementById("password").value="";
	}
</script>
</head>
<body>
<div align="center" style="padding-top: 20px;">
	<form action="manager!login" method="post" onsubmit="return checkForm()">
		账&nbsp;&nbsp;号：<input type="text" id="userName" name="manager.userName" value="${manager.userName }"/><br><br>
		密&nbsp;&nbsp;码：<input type="password" id="password" name="manager.password" value="${manager.password }"/><br><br>
		<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" />
	</form>
</div>
<script>
	if('${error}'!=''){
		alert('${error}');
	}
</script>
</body>
</html>
