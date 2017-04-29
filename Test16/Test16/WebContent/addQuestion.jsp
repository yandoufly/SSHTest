<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	录入题目:<hr>
    <s:form action="addQuestion" theme="simple">
    	题目内容:<s:textfield name="question.content"></s:textfield><br>
 		选项A:<s:textfield name="question.options[0].content"></s:textfield>
	 		<s:hidden name="question.options[0].mark" value="A"/>
	 		<s:checkbox name="question.options[0].yes" /><br>
	 		
		 选项B:<s:textfield name="question.options[1].content"></s:textfield>
			 <s:hidden name="question.options[1].mark" value="B"/>
			 <s:checkbox name="question.options[1].yes" /><br>
			 
		 选项C:<s:textfield name="question.options[2].content"></s:textfield>
			 <s:hidden name="question.options[2].mark" value="C"/>
			 <s:checkbox name="question.options[2].yes" /><br>
			 
		 选项D:<s:textfield name="question.options[3].content"></s:textfield>
			 <s:hidden name="question.options[3].mark" value="D"/>
			 <s:checkbox name="question.options[3].yes" /><br>	
 		<s:submit value="提交"></s:submit>
 	</s:form>
 	<s:fielderror fieldName="error"></s:fielderror>
</center>
</body>
</html>