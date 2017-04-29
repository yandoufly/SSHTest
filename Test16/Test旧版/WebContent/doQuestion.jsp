<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doQuestion.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
	<script type="text/javascript">
		
		$(document).ready(function(){
			//给上一题按钮添加事件
			$("a").first().click(function(){
				$("form").attr("action","preQuestion").submit();
				return false;
			}).next().click(function(){
				$("form").attr("action","nextQuestion").submit();
				return false;
			}).next().click(function(){
				$("form").attr("action","commitExamPaper").submit();
				return false;
			})
			
		});
		
	</script>
  </head>
  
  <body>
     	第${index+1}题:${q.content}
     	<hr>
     	A:${q.options[0].content }<br>
     	B:${q.options[1].content }<br>
     	C:${q.options[2].content }<br>
     	D:${q.options[3].content }
     	<hr>
     	<form>
     	<input type="hidden" name="index" value="${index}">
     	<input type="hidden" name="paperId" value="${paperId}">
     	A:<s:checkbox name="answers[0].yes"/><s:hidden name="answers[0].mark" value="A" /><s:hidden name="answers[0].answerId"/>
     	B:<s:checkbox name="answers[1].yes"/><s:hidden name="answers[1].mark" value="B" /><s:hidden name="answers[1].answerId"/>
     	C:<s:checkbox name="answers[2].yes"/><s:hidden name="answers[2].mark" value="C" /><s:hidden name="answers[2].answerId"/>
     	D:<s:checkbox name="answers[3].yes"/><s:hidden name="answers[3].mark" value="D" /><s:hidden name="answers[3].answerId"/>
     	请选择答案:
     	<hr>
     	  <a href="#">上一题</a><a href="#">下一题</a><a href="#">提交试卷</a>
     	</form>
  </body>
</html>
