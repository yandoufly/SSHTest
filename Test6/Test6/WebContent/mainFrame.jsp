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
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#addSContest").click(function(){
			alert("您还没登录，不能参加竞赛");
			return false;
		});
	})
</script>
</head>
<body>
<center>
${msg } <br>

<div>
	<a href="${pageContext.request.contextPath }/login.jsp">登录</a> 
	&nbsp; | &nbsp;
	<a href="${pageContext.request.contextPath }/student/register.jsp">学生注册</a>
	&nbsp; | &nbsp;
	<a href="${pageContext.request.contextPath }/teacher/register.jsp">教师注册</a>

	&nbsp; | &nbsp;
	<a href="${pageContext.request.contextPath }/main-getmoreContest">分页竞赛</a>
</div>
<br>
<div>
	<div id="left" style="display:inline-block;">
		<div>竞赛信息<a href="main-getmoreContest">[更多]</a></div>
		<c:if test="${not empty requestScope.allContest }">
			<table border="1">
				<tr>
					<th>主题</th>
					<th>竞赛开始时间</th>
					<th>查看</th>
					<th>参加竞赛</th>
				</tr>
				<c:forEach items="${allContest }" var="contest" varStatus="vs">
					<c:if test="${vs.index < 3 }">
					<tr>
						<td>${contest.title }</td>
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
					</c:if>
				</c:forEach>
			</table>
		</c:if>
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div id="right" style="display:inline-block;">
		<div>新闻公告信息<a href="main-getmoreMessage">[更多]</a></div>
		<c:if test="${not empty requestScope.allMessage }">
			<table border="1">
				<tr>
					<th>主题</th>
					<th>创建时间</th>
					<th>查看</th>
				</tr>
				<c:forEach items="${allMessage }" var="message" varStatus="vs">
					<c:if test="${vs.index < 3 }">
						<tr>
							<td>${message.title }</td>
							<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd"/></td>
							<td>
								<form action="main-knowMessage" method="post">
									<input type="hidden" name="id" value="${message.id }">
									<input type="submit" value="查看">
								</form>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:if>
	</div>
</div>
</center>
</body>
</html>