<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/side.js"></script>
</head>

<body>
<input type="hidden" id="msg" value="${msg}">
<!-- wrap_left -->
<jsp:include page="wrap_left.jsp" />


<!-- wrap_right -->
<div class="wrap_right">

	<jsp:include page="header.jsp" />
	<!-- Contents -->
	<div id="Contents">
	<script type="text/javascript">
			$(function(){
			$(".select").each(function(){
				var s=$(this);
				var z=parseInt(s.css("z-index"));
				var dt=$(this).children("dt");
				var dd=$(this).children("dd");
				var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
				var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
				dt.click(function(){dd.is(":hidden")?_show():_hide();});
				dd.find("a").click(function(){dt.html($(this).html());_hide();});
				$("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
	</script>

		<!-- MainForm -->
		<div id="MainForm">
			<img alt="后台管理系统" src="images/aa.jpg">
		</div>
	</div>
	<!-- /Contents -->
	<jsp:include page="footer.jsp" />
</div>
<!-- /wrap_right -->
</body>
</html>