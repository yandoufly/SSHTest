<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newExam.jsp' starting page</title>
    
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
    	发起一场考试
    	<s:form action="addExam" theme="simple">
    	 考试名字:<s:textfield name="exam.examName"></s:textfield><br>
    	考试时间:<s:select list="{1,30,60,90,120,150}" name="exam.examTime"></s:select>分钟<br>
    	考试题量:<s:textfield name="exam.examQuestionCount"></s:textfield><br>
    	考试总分:<s:textfield name="exam.examTotalScore"></s:textfield><br>
    	<s:submit value="提交"></s:submit>
    	</s:form>
  </body>
</html>
