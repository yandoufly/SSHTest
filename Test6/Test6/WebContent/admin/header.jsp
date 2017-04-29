<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<head>
	<!-- Header -->
	<div id="Header">
		<!-- Head -->
		<div id="Head">
			<h1 title="高校学生科技竞赛信息管理系统"><img src="images/common/title.gif" width="398" height="26" alt="高校学生科技竞赛信息管理系统"></h1>
			<script language="javascript">
				function showmenu(id){id.style.visibility = "visible";}
				function hidmenu(){UserList.style.visibility = "hidden";}
				document.onclick = hidmenu;
			</script>
			<div class="user"><a href="javascript:showmenu(UserList)">${admin.name }</a>
				<div id="UserList">
					<a href="#">退出登录</a>
					<a href="#">注销</a>
				</div>
			</div>
		</div>
		
		<div> <font color="red">${msg}</font> </div>
		
		<!-- /Head -->
		<nav>
			<ul id="Navi">
				<li><a href="${pageContext.request.contextPath }/admin/mainFrame.jsp"><img src="images/common/navi01.png" width="30" height="36" alt="主页管理"><span>主页管理</span></a></li>
				<li><a href="admin-checkStudent"><img src="images/common/navi02.png" width="36" height="36" alt="审核学生账号"><span>审核学生账号</span></a></li>
				<li><a href="${pageContext.request.contextPath }/admin/addListStudent.jsp"><img src="images/common/navi02.png" width="36" height="36" alt="导入学生账号"><span>导入学生账号</span></a></li>
				<li><a href="admin-checkTeacher"><img src="images/common/navi03.png" width="26" height="36" alt="审核教师账号"><span>审核教师账号</span></a></li>
				<li><a href="${pageContext.request.contextPath }/admin/addListTeacher.jsp"><img src="images/common/navi02.png" width="36" height="36" alt="导入教师账号"><span>导入教师账号</span></a></li>
				<li><a href="${pageContext.request.contextPath }/admin/addContest.jsp"><img src="images/common/navi04.png" width="34" height="36" alt="发布竞赛"><span>发布竞赛</span></a></li>
				<li><a href="${pageContext.request.contextPath }/admin/addMessage.jsp"><img src="images/common/navi05.png" width="24" height="36" alt="发布公告"><span>发布公告</span></a></li>
				<li><a href="admin-getAllContest"><img src="images/common/navi06.png" width="36" height="36" alt="添加获奖名单"><span>添加获奖名单</span></a></li>
			</ul>
		</nav>
	</div>
	<!-- /Header -->
</head>