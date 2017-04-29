<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布竞赛</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#addfile").click(function(){
			$("#filefile").append("<div>添加文件：<input type='file' name='upload'><br></div>");
		})
	})
</script>
</head>
<body>
<center>
${msg } <br>
<form action="ContestAction" method="post" enctype="multipart/form-data">
<table>

	<input type="hidden" name="isDisplay" value="0">
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
</center>
</body>
</html>