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
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/side.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("#contest").change(function(){
			var contest = $(this).val();
			if(contest != ""){
				$("#SContest tr:not(:first)").remove();
				
				var url="admin-showStuContest";
				var args={"contestId":contest,"time":new Date()};
				$.getJSON(url,args,function(data){
					if(data.length==0){
						alert("当前没有获奖信息！！");
					}else{
						for(var i=0;i<data.length;i++){
							
							var id=data[i].id;
							var contestId=data[i].contest.id;
							var contestTitle=data[i].contest.title;
							var studentId=data[i].student.studentId;
							var studentName=data[i].student.name;
							var rank=data[i].rank;
							$("#SContest").append(
									"<tr>"
										+"<td>"+id+"</td>"
										+"<td>"+contestTitle+"</td>"
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
				var url="admin-exportExcelStuContest";
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
<!-- wrap_left -->
<jsp:include page="wrap_left.jsp" />

<!-- wrap_right -->
<div class="wrap_right">
<jsp:include page="header.jsp" />
<div id="Contents">
	<div>
		<select id="contest">
			<option value="">请选择</option>
			<c:forEach items="${allContest }" var="contest">
				<option value="${contest.id}">${contest.title }</option>
		    </c:forEach>
		</select>
	</div>
	<div>
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
		
		<button id="export">导出格式为xlsx 的 Excel表</button><br>
		
		<h3>通过Excel表(必须为xlxs格式文件) 更新获奖消息</h3>
		<form action="admin-importStuContest">
			Excelfile:<input type="file" name="excelFile"><br>
			<input type="submit" value="提交">
		</form>
	</div>
</div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>