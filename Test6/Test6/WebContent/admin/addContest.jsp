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
<script type="text/javascript">
	$(function(){
		$("#addfile").click(function(){
			$("#filefile").append("<div>添加文件：<input type='file' name='upload'><br></div>");
		})
	})
</script>
</head>

<body>
<!-- wrap_left -->
<jsp:include page="wrap_left.jsp" />

<!-- wrap_right -->
<div class="wrap_right">
<jsp:include page="header.jsp" />

<div id="Contents">
	<div id="MainForm">
		<form action="ContestAction" method="post" enctype="multipart/form-data">
			<input type="hidden" name="isDisplay" value="1">
			<table>
				<tr><td>主题：</td><td><input type="text" name="title"></td></tr>
				<tr><td>级别：</td><td><input type="text" name="grade"></td></tr>
				<tr><td>主办方：</td><td><input type="text" name="organiser"></td></tr>
				<tr><td>竞赛时间：</td><td><input type="text" name="startTime"></td></tr>
				<tr><td>报名结束时间：</td><td><input type="text" name="endRegTime"></td></tr>
				<tr><td>内容：</td><td><textarea rows="10" cols="20" name="content"></textarea></td></tr>
			</table>	
			
			<div id="filefile"></div>
			<input id="addfile" type="button" value="添加附件"><br>
			<input type="submit" value="提交">
		</form>
	</div>
</div>

<jsp:include page="footer.jsp" />
</div>

</body>
</html>