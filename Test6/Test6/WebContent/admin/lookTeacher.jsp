<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/"; 
%>
<html>
<head>
<base href="<%=basePath%>"> 
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
	 <div><h3>查看教师个人信息</h3></div>
	 <div>
	 	工号：<input type="text" value="${teacher.teacherId }"><br>
	 	姓名：<input type="text" value="${teacher.name }"><br>
	 	密码：<input type="text" value="${teacher.passwd }"><br>
	 	性别：<input type="text" value="${teacher.sex }"><br>
	 	出生：<input type="text" value="${teacher.birthday }"><br>
	 	教师职类：<input type="text" value="${teacher.profess }"><br>
	 	电话：<input type="text" value="${teacher.telephone }"><br>
	 	QQ：<input type="text" value="${teacher.qq }"><br>
	 	微信：<input type="text" value="${teacher.weixin }"><br>
	 	个人简介：<textarea rows="20" cols="25">${teacher.profiles }</textarea><br>
	 	<a href="javascript:history.back(1);">返回上一页</a>
	 </div>
</div>

<jsp:include page="footer.jsp" />
</div>

</body>
</html>