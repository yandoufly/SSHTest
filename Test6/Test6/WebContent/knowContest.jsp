<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/"; 
%>
<html>
<head>
<base href=" <%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#entryContest").click(function(){
			 var s =  $(this).prev().val();
			 var studentId =  $(this).prev().prev().val();
			 if(studentId==""){
				 alert("用户还没登录，不能参加竞赛！");
			 	return false;
			 }
			 alert("s:" + s +", ss:" + ss);
			 return false;
		});
	})
</script>
</head>
<body>
<center>
主题：<input type="text" value="${contest.title }"><br>
级别： <input type="text" value="${contest.grade }"><br>
主办方： <input type="text" value="${contest.organiser }"><br>
开始时间：<input type="text" value="<fmt:formatDate value="${contest.startTime }" pattern="yyyy-MM-dd"/>"><br>
报名截止时间：<input type="text" value="<fmt:formatDate value="${contest.endRegTime }" pattern="yyyy-MM-dd"/>"><br>
主要内容:<textarea rows="10" cols="20" >${contest.content }</textarea>
<br>
	
<c:if test="${not empty fileNames }">
	<table border="1" align="center">
		<tr>
			<td>编号</td>
			<td>文件名</td>
			<td>操作</td>
		</tr>
		<c:forEach var="fileName" items="${fileNames}" varStatus="vs">
			<tr>
				<td>${vs.count }</td>
				<td>${fileName }</td>
				<td>
					<!-- 构建一个url -->
					<c:url var="url" value="main-down">
						<c:param name="fileName" value="${fileName}"></c:param>
					</c:url>
					
					<a href="${url }">下载</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	<br><br>
	<form action="student_entryContest" method="post">
		<input type="hidden" name="studentId" value="${student.studentId }">
		<input type="hidden" name="contestId" value="${contest.id }">
		<input id="entryContest" type="submit" value="参加该竞赛">
	</form><br>
	<a href="javascript:history.back(1);">返回上一页</a>
</center>
</body>
</html>