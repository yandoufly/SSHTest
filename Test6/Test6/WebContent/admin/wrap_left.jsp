<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/side.js"></script>
<!-- wrap_left -->
<div class="wrap_left" id="frmTitle" name="fmTitle">
<!-- Logo -->
<div id="Logo"><span>后台处理</span></div>
<!-- /Logo -->

<!-- menu_list -->
<script>
$(function() {
    $(".menu_list dd");
    $(".menu_list dt").click(function(){
        $(this).toggleClass("open").next().slideToggle("fast");
    });
});
</script>
<div class="menu_list">
	<dl>
	<dt><span>学生管理</span></dt>
		<dd><a href="admin-checkStudent" title="审核学生账号">审核学生账号</a>
			<a href="${pageContext.request.contextPath }/admin/cancelStudent.jsp" title="注销学生账号">注销学生账号</a>
			<a href="${pageContext.request.contextPath }/admin/resetStuPasswd.jsp" title="重置学生密码">重置学生密码</a>
			<a href="${pageContext.request.contextPath }/admin/addListStudent.jsp" title="批量导入学生账号" class="active">批量导入学生账号</a>
		</dd>
	
	<dt><span>教师管理</span></dt>
		<dd><a href="admin-checkTeacher" title="审核教师账号">审核教师账号</a>
			<a href="${pageContext.request.contextPath }/admin/cancelTeacher.jsp" title="注销教师账号">注销教师账号</a>
			<a href="${pageContext.request.contextPath }/admin/resetTeaPasswd.jsp" title="重置教师密码">重置教师密码</a>
			<a href="${pageContext.request.contextPath }/admin/addListTeacher.jsp" title="批量导入教师账号" class="active">批量导入教师账号</a>
		</dd>
	
	<dt><span>竞赛管理</span></dt>
		<dd><a href="${pageContext.request.contextPath }/admin/addContest.jsp" title="发布竞赛">发布竞赛</a>
			<a href="admin-checkTContest" title="审核教师发布的竞赛">审核教师发布的竞赛</a>
			<a href="admin-getAllContest" title="添加获奖消息">添加获奖消息</a>
		</dd>
	
	<dt><span>公告管理</span></dt>
		<dd><a href="${pageContext.request.contextPath }/admin/addMessage.jsp" title="发布公告">发布公告</a>
			<a href="admin-checkTMessage" title="审核教师发布的公告">审核教师发布的公告</a>
		</dd>
	
	</dl>
</div>
<!-- /menu_list -->
</div>
<!-- /wrap_left -->

<!-- picBox -->
<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
<!-- /picBox -->