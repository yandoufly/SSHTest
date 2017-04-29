<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="com.zx.yc27.core" prefix="z"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>管理页面</title>

<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
</head>

<body>
<h1 class="type"><a href="javascript:void(0)">用户管理</a></h1>
<ul class="MM">
  <li><a href="addStudent.jsp" target="main">添加用户</a></li>
</ul>

<h1 class="type"><a href="javascript:void(0)">权限管理</a></h1>
<ul class="MM">
  <li><a href="addRole.jsp" target="main">添加角色</a></li>
  <li><a href="showAllRole" target="main">设置角色权限</a></li>
  <li><a href="showAllUser" target="main">设置用户角色</a></li>
</ul>

<h1 class="type"><a href="javascript:void(0)">题库管理</a></h1>
<ul class="MM">
  <li><a href="addQuestionPage" target="main">添加考题</a></li>
  <li><a href="showAllQuestion" target="main">查询考题</a></li>
</ul>

<h1 class="type"><a href="javascript:void(0)">试卷管理</a></h1>
<ul class="MM">
  <li><a href="newExam.jsp" target="main">发布考试</a></li>
</ul>

<h1 class="type"><a href="javascript:void(0)">考试管理</a></h1>
<ul class="MM">
  <li><a href="showAllExam" target="main">我的考试</a></li>
  <li><a href="showMyPaper" target="main">我的试卷</a></li>
</ul>
</body>
</html>
