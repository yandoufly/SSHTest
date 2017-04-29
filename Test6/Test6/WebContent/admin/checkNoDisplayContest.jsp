<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
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
</head>

<body>
<!-- wrap_left -->
<jsp:include page="wrap_left.jsp" />


<!-- wrap_right -->
<div class="wrap_right">
<jsp:include page="header.jsp" />

<h2>审核教师发布的竞赛信息</h2>
${msg } <br>
<div id="MainForm">
	<div class="form_boxB">
		<c:if test="${requestScope.allNoDisplayContest!=null || fn:length(requestScope.allNoDisplayContest)!=0}">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<th>主题</th>
					<th>级别</th>
					<th>主办方</th>
					<th>竞赛时间</th>
					<th>报名截止时间</th>
					<th>显示在页面</th>
					<th>删除</th>
				</tr>
				<c:forEach items="${allNoDisplayContest }" var="contest">
					<tr>
						<td>${contest.title }</td>
						<td>${contest.grade }</td>
						<td>${contest.organiser }</td>
						<td><fmt:formatDate value="${contest.startTime }" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${contest.endRegTime }" pattern="yyyy-MM-dd"/></td>
						<td>
							<form action="admin-activeContest" method="post">
								<input type="hidden" name="id" value="${contest.id }">
								<input type="submit" value="是">
							</form>
						</td>
						<td>
							<form action="admin-delContest" method="post">
								<input type="hidden" name="id" value="${contest.id }">
								<input type="submit" value="删除">
							</form>
						</td>
					</tr>
				</c:forEach>
		
			</table>
		</c:if>
	</div>
</div>

<jsp:include page="footer.jsp" />
</div>
</body>
</html>