<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>管理中心</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
<style type="text/css">
.header{border-bottom:1px solid #ccc;margin-bottom:5px;}
.MainContainer{min-width:960px;max-width:1600px;}
.sidebar{width:180px;float:left;margin-right:-180px;border-right:1px solid #ccc;min-height:500px;padding:5px;}
.main{float:left;margin-left:200px;padding:5px;}
.content{padding:0 10px;}
</style>
</head>
<body>
	<div class="page">
        <div class="header">
            <div id="title">
                <jsp:include page="admin_top.jsp"></jsp:include>
            </div>
        </div>
        <div class="MainContainer">
            <div class="sidebar">
           		<jsp:include page="left.jsp"></jsp:include>
            </div>
            <div  id="main" class="main">
                <jsp:include page="right.html"></jsp:include>
            </div>           
        </div>
    </div>
</body>
<!-- <frameset rows="64,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="admin_top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
	<frameset cols="200,*"  rows="560,*" id="frame">
		<frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
		<frame src="right.html" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
	</frameset>
</frameset>
<noframes>
</noframes> -->

</html>
