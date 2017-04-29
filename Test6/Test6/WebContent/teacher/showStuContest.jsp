<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/"; 
%>
<html>
<head>
<base href=" <%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#contest").change(function(){
			var contest = $(this).val();
			if(contest != ""){
				$("#SContest tr:not(:first)").remove();
				
				var url="teacher_showStuContest";
				var args={"contestId":contest,"time":new Date()};
				$.getJSON(url,args,function(data){
					if(data.length==0){
						alert("当前没有获奖信息！！");
					}else{
						for(var i=0;i<data.length;i++){
							var contestTile=data[i].contest.title;
							var studentId=data[i].student.studentId;
							var studentName=data[i].student.name;
							var rank=data[i].rank;
							$("#SContest").append(
									"<tr>"
										+"<td>"+i+1+"</td>"
										+"<td>"+contestTile+"</td>"
										+"<td>"+studentId+"</td>"
										+"<td>"+studentName+"</td>"
										+"<td>"+rank+"</td>"
									+"</tr>"	
									);
						}
					}
				});
			}
		});
	})
</script>

<script type="text/javascript">
	$(function(){
		//导出Excel表格
		$("#export").click(function(){
			var contest = $("#contest").val();
			if(contest != ""){
				var url="teacher_exportExcelStuContest";
				var args={"contestId":contest,"time":new Date()};
				$.post(url, args, function(data){
					if(confirm("是否确认导出？")){
						if(data=="ok"){
							alert("已存到D:\\upload文件夹中  ^_^ ");
						}
					}else{
						alert("下载失败！");
					}
				});
			}
		});
	})
</script>
</head>
<body>
竞赛名<br>
<select id="contest">
	<option value="">请选择</option>
	<c:forEach items="${allContest }" var="contest">
		<option value="${contest.id}">${contest.title }</option>
    </c:forEach>
</select><br>
<br><br>

<table border="1" id="SContest">
	<tr>
		<td>编号</td>
		<td>竞赛名称</td>
		<td>学生学号</td>
		<td>学生姓名</td>
		<td>几等奖</td>
	</tr>
</table>
<br><br>
<button id="export">导出Excel表</button><br>
<h3>通过[格式必须为xx.xlxs] Excel表 更新获奖消息</h3>
<form action="teacher_importStuContest">
	Excelfile:<input type="file" name="excelFile"><br>
	<input type="submit" value="提交">
</form>
</body>
</html>