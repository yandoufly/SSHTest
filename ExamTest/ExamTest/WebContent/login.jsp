<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考生登录</title>
<link href="${pageContext.request.contextPath}/style/exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm(){
		var id=document.getElementById("id").value;
		var password=document.getElementById("password").value;
		if(id==null || id==""){
			alert("准考证号不能为空！");
			return false;
		}
		if(password==null || password==""){
			alert("登录密码不能为空！");
			return false;
		}
		return true;
	}

</script>
</head>
<body>
<script type="text/javascript">
	if('${error}'!=''){
		alert('${error}');
	}
</script>
<div align="center" style="padding-top: 20px;">
	<form action="student!login" method="post" onsubmit="return checkForm()">
		准考证号：<input type="text" id="id" name="student.id" value="${student.id }"/><br><br>
		登录密码：<input type="password" id="password" name="student.password" value="${student.password }"/><br><br>
		<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" />
	</form>
</div>
</body>
</html>
