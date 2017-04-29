<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="ckeditor/ckeditor.js"></script> 
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
		<form action="MessageAction" method="post">
			主题： <input type="text" name="message.title"><br>
			内容： <textarea name="message.content"></textarea>
 			 	<script type="text/javascript">CKEDITOR.replace('message.content');</script><br>
			<input type="hidden" name="message.isDisplay" value="1">
			<input type="submit" value="提交"><br>
		</form>
	</div>
</div>
</div>

<jsp:include page="footer.jsp" />
</div>
</body>
</html>