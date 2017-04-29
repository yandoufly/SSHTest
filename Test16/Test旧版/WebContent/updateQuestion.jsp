<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addQuestion.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    	修改题目:
    <hr>
    <s:form action="updateQuestion" theme="simple">
    题目内容:<s:textfield name="question.content"></s:textfield><br>
 选项A:<s:textfield name="question.options[0].content"></s:textfield><s:hidden name="question.options[0].mark" value="A"/><s:checkbox name="question.options[0].yes" /><br>
 选项B:<s:textfield name="question.options[1].content"></s:textfield><s:hidden name="question.options[1].mark" value="B"/><s:checkbox name="question.options[1].yes" /><br>
 选项C:<s:textfield name="question.options[2].content"></s:textfield><s:hidden name="question.options[2].mark" value="C"/><s:checkbox name="question.options[2].yes" /><br>
 选项D:<s:textfield name="question.options[3].content"></s:textfield><s:hidden name="question.options[3].mark" value="D"/><s:checkbox name="question.options[3].yes" /><br>	
 	<s:submit value="保存修改"></s:submit>
 	
 	<!-- 隐藏字段，保存id -->
 	<s:hidden name="question.qid"></s:hidden>
 	</s:form>
 	<s:fielderror fieldName="error"></s:fielderror>
  </body>
</html>
