<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示所有员工</title>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var url="${pageContext.request.contextPath}/emp/findAllEmpMethod.action";
		var args={"time":new Date()};
		$.getJSON(url,args,function(data){
			if(data.length==0){
				alert("当前没有信息！！");
			}else{
				for(var i = 0; i < data.length; i++){
					var empno = data[i].empno;
					var username = data[i].username;
					var salary = data[i].salary;
					var hiredate = data[i].hiredate;
					$("#showEmp").append(
						"<tr>"
							+"<td>"+empno+"</td>"
							+"<td>"+username+"</td>"
							+"<td>"+salary+"</td>"
							+"<td>"+hiredate+"</td>"
						+"</tr>"	
					);
				}
			}
		});
	})
</script>
</head>
<body>
<table id="showEmp" border="1" cellpadding="5">
	<tr>
		<td>学号</td>
		<td>姓名</td>
		<td>薪水</td>
		<td>入职时间</td>
	</tr>
</table>
</body>
</html>