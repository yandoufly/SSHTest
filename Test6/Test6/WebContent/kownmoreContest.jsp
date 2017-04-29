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
		});	
	})
</script>
</head>
<body>
<center>
<div>
	<div>竞赛信息</div>
	<div>
	<c:if test="${not empty requestScope.allContest }">
		<table border="1">
			<tr>
				<th>主题</th>
				<th>主办方</th>
				<th>竞赛开始时间</th>
				<th>查看</th>
				<th>参加竞赛</th>
			</tr>
			<c:forEach items="${allContest }" var="contest">
				<tr>
					<td>${contest.title }</td>
					<td>${contest.organiser }</td>
					<td><fmt:formatDate value="${contest.startTime }" pattern="yyyy-MM-dd"/></td>
					<td>
						<form action="main-knowContest" method="post">
							<input type="hidden" name="id" value="${contest.id }">
							<input type="submit" value="查看">
						</form>
					</td>
					<td>
						<form action="student_entryContest" method="post">
							<input type="hidden" name="studentId" value="${student.studentId }">
							<input type="hidden" name="contestId" value="${contest.id }">
							<input id="entryContest" type="submit" value="参加该竞赛">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	<br><br>
	<a href="javascript:history.back(1);">返回上一页</a>
</div>
</center>
</body>
</html>