<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有用户</title>
<script type="text/javascript">
	function searchByUsername(){
		var username =  document.getElementById("username").value;
		alert("username:" + username);
		document.forms[0].action = "${pageContext.request.contextPath }/userServlet?username=" + username;
   		document.forms[0].submit();
	}
</script>
</head>
<body>
<br><br>
<center>
<form name="queryForm" action="" method="post" enctype="multipart/form-data">
	<div>
		用户名搜索：<input type="text" id="username" name="username">
		&nbsp;&nbsp;
		<input type="button" onclick="searchByUsername()" value="搜索">
	</div>
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
  		<tr>
  			<th>序号</th>
  			<th>用户名</th>
  			<th>密码</th>
  			<th>更新时间</th>
  		</tr>
  		<!-- 迭代数据 -->
  		<c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="user" items="${requestScope.pageBean.pageData}" varStatus="vs">
  					<tr>
  						<td>${vs.count }</td>
  						<td>${user.username }</td>
  						<td>${user.password }</td>
  						<td><fmt:formatDate value="${user.updatetime }" pattern="yyyy-MM-dd"/></td>
  					</tr>
  				</c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="3">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="7" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/userServlet?currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/userServlet?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				&nbsp;
  				<!-- 页数列表 -->
				<c:forEach items="${requestScope.pageBean.pageList}" var="item">
					<c:choose>
						<c:when test="${item == pageIndex}">
							<a href="#">${item}</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath }/userServlet?currentPage=${item}">${item}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				&nbsp;
  				<a href="${pageContext.request.contextPath }/userServlet?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="${pageContext.request.contextPath }/userServlet?currentPage=${requestScope.pageBean.totalPage}">末页</a>
  				
  				&nbsp;&nbsp;
  				跳转到<input type="text" id="jumpTo" >页 
  				<a href="#" onclick="jumpTo(${totalPage})" > 
					<input type="button" value="跳转" class="page_button"/>
				</a>
  				<script type="text/javascript">
  					function jumpTo(totalPage){
  						var page =  document.getElementById("jumpTo").value;
  						//alert(page);
  					    if(page > totalPage || page < 1){
  					        alert("对不起，无法到达该页");
  					        return;
  					    }else{
  							document.forms[0].action = "${pageContext.request.contextPath }/userServlet?currentPage="+page;
  							document.queryForm.submit();	
  					    }
  					}
  				</script>
  			</td>
  		</tr>
  	</table>
</form>
</center>
</body>
</html>