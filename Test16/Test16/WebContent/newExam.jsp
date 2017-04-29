<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	<h3>发起一场考试</h3>
	<s:form action="addExam" theme="simple">
	    	 考试名字:<s:textfield name="exam.examName"></s:textfield><br>
	    	考试时间:<s:select list="{1,30,60,90,120,150}" name="exam.examTime"></s:select>分钟<br>
	    	考试题量:<s:textfield name="exam.examQuestionCount"></s:textfield><br>
	    	考试总分:<s:textfield name="exam.examTotalScore"></s:textfield><br>
    	<s:submit value="提交"></s:submit>
    </s:form>
</center>
</body>
</html>