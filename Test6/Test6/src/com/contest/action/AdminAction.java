package com.contest.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.contest.entities.Contest;
import com.contest.entities.Message;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;
import com.contest.service.AdminService;
import com.contest.utils.MyExcel;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("AdminAction")
public class AdminAction extends ActionSupport implements RequestAware,ServletResponseAware {
	
	@Resource
	private AdminService adminService;
	private Map<String, Object> request;
	private HttpServletResponse response;
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//审核学生未激活的账号
	public String checkStudent(){
		List<Student> allNoStatusStudents = adminService.getAllNoStatusStudent();
		request.put("allNoStatusStudents", allNoStatusStudents);
		return "allNoStatusStudents";
	}

	//激活学生
	public String activeStudent(){
		boolean b = adminService.activeStudent(id);
		if(b){
			request.put("msg", "已激活该学生账号");
			return "adminMainFrame";
		}
		
		request.put("msg", "激活该学生账号失败");
		return checkStudent();
		
	}
	
	//删除该学生
	public String delStudent(){
		boolean b = adminService.delStudent(id);
		if(b){
			request.put("msg", "已删除该学生");
			return "adminMainFrame";
		}
		request.put("msg", "删除该学生账号失败");
		return checkStudent();
	}
	
	//重置学生密码
	public String resetStuPasswd(){
		boolean b = adminService.resetStuPasswd(id);
		if(b){
			request.put("msg", "已重置该学生密码");
		}else{
			request.put("msg", "重置该学生密码失败");
		}
		return "adminMainFrame";
	}
	
	//注销学生账号
	public String cancelStudent(){
		boolean b = adminService.cancelStudent(id);
		if(b) {
			request.put("msg", "已成功注销该学生账号");
		}else{
			request.put("msg", "已成功注销该学生账号");
		}
		return "adminMainFrame";
	}
	
	
	//审核教师账号
	public String checkTeacher(){
		List<Teacher> allNoStatusTeachers = adminService.getAllNoStatusTeacher();
		request.put("allNoStatusTeachers", allNoStatusTeachers);
		return "allNoStatusTeachers";
	}
	
	//激活教师账号
	public String activeTeacher(){
		boolean b = adminService.activeTeacher(id);
		if(b){
			request.put("msg", "已激活该教师账号");
			return "adminMainFrame";
		}
		
		request.put("msg", "激活该教师账号失败");
		return checkTeacher();
	}
	
	//删除该教师账号
	public String delTeacher(){
		boolean b = adminService.delTeacher(id);
		if(b){
			request.put("msg", "已删除该教师");
			return "adminMainFrame";
		}
		request.put("msg", "删除该教师账号失败");
		return checkTeacher();
	}
	
	//重置教师密码
	public String resetTeaPasswd(){
		boolean b = adminService.resetTeaPasswd(id);
		if(b){
			request.put("msg", "已重置该教师密码");
		}else{
			request.put("msg", "重置该教师密码失败");
		}
		return "adminMainFrame";
	}
	
	//注销教师账号
	public String cancelTeacher(){
		boolean b = adminService.cancelTeacher(id);
		if(b){
			request.put("msg", "已成功注销该教师账号");
		}else{
			request.put("msg", "操作失败");
		}
		return "adminMainFrame";
	}
	
	//查看老师个人资料
	public String lookTeacher(){
		Teacher teacher = adminService.lookTeacher(id);
		if(teacher != null){
			request.put("teacher", teacher);
			return "lookTeacher";
		}
		request.put("msg", "操作失败！！！");
		return "adminMainFrame";
	}
	
	//审核教师发布的未激活竞赛
	public String checkTContest(){
		List<Contest> allNoDisplayContest = adminService.getAllTContest();
		request.put("allNoDisplayContest", allNoDisplayContest);
		return "allNoDisplayContest";
	}
	
	//使竞赛能显示在页面上
	public String activeContest(){
		boolean b = adminService.activeContest(id);
		if(b){
			request.put("msg", "已将该竞赛信息显示到页面上");
			return "adminMainFrame";
		}
		request.put("msg", "操作失败！！");
		return checkTContest();
	}
	
	//删除该竞赛信息
	public String delContest(){
		boolean b = adminService.delContest(id);
		if(b){
			request.put("msg", "已将该竞赛信息删除");
			return "adminMainFrame";
		}
		request.put("msg", "操作失败！！");
		return checkTContest();
	}
	
	//得到全部竞赛
	public String getAllContest(){
		List<Contest> allContest = adminService.getAllContest();
		request.put("allContest", allContest);
		return "listContest";
	}
	
	
	//审核教师发布的未激活的新闻公告
	public String checkTMessage(){
		List<Message> allNoDisplayMessage = adminService.getAllTMessage();
		request.put("allNoDisplayMessage", allNoDisplayMessage);
		return "allNoDisplayMessage";
	}
	
	//激活教师发布的新闻公告
	public String activeMessage(){
		boolean b = adminService.activeMessage(id);
		if(b){
			request.put("msg", "已将该新闻公告显示到页面上");
			return "adminMainFrame";
		}
		request.put("msg", "操作失败！！");
		return checkTMessage();
	}
	
	//删除该竞赛信息
	public String delMessage(){
		boolean b = adminService.delMessage(id);
		if(b){
			request.put("msg", "已将该新闻公告删除");
			return "adminMainFrame";
		}
		request.put("msg", "操作失败！！");
		return checkTContest();
	}
	
	private String excelFile;
	public String getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}
	//批量导入学生账号
	public String importListStudent() throws IOException {
		List<Student> list = MyExcel.readXlsx(excelFile,  1);
		boolean b = adminService.insertListStudent(list);
		if(b){
			request.put("msg", "导入学生成功");
		}else{
			request.put("msg", "导入学生失败");
		}
		return "adminMainFrame";
		
	}

	//批量导入学生账号
	public String importListTeacher() throws IOException {
		List<Teacher> list = MyExcel.readXlsx(excelFile, 2);
		boolean b = adminService.insertListTeacher(list);

		if(b){
			request.put("msg", "导入老师成功");
		}else{
			request.put("msg", "导入老师失败");
		}
		return "adminMainFrame";
		
	}
	
	private int contestId;
	public void setContestId(int contestId) {
		this.contestId = contestId;
	}
	//显示获奖信息
	public String showStuContest(){
		List<StudentContest> list = adminService.getStuContestByconstestId(contestId);
		
		request.put("list", list);
		ObjectMapper mapper=new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(list);
			
			System.out.println(result);
			
			response.setContentType("text/javascript");
			response.setCharacterEncoding("utf-8");
			
			response.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	//导出学生获奖信息情况
	public String exportExcelStuContest(){
		System.out.println("test exportExcelStuContest");
		response.setContentType("text/html;charset=utf-8");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		//在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow((int) 0);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("编号");
		cell.setCellStyle(style);  
		
		cell = row.createCell(1);
		cell.setCellValue("竞赛编号");
		cell.setCellStyle(style);  
		
		cell = row.createCell(2);
		cell.setCellValue("竞赛名称");
		cell.setCellStyle(style);  
		
		cell = row.createCell(3);
		cell.setCellValue("学生学号");
		cell.setCellStyle(style);  
		
		cell = row.createCell(4);
		cell.setCellValue("学生姓名");
		cell.setCellStyle(style);  

		cell = row.createCell(5);
		cell.setCellValue("几等奖");
		cell.setCellStyle(style);  
		
		// 得到实际的值
		List<StudentContest> list = adminService.getStuContestByconstestId(contestId);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			StudentContest studentContest = (StudentContest) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(studentContest.getId());
			row.createCell(1).setCellValue(studentContest.getContest().getId());
			row.createCell(2).setCellValue(studentContest.getContest().getTitle());
			row.createCell(3).setCellValue(studentContest.getStudent().getStudentId());
			row.createCell(4).setCellValue(studentContest.getStudent().getName());
			row.createCell(5).setCellValue(studentContest.getRank());
		}

		try {
			File ff = new File("D:\\upload\\contestNo."+contestId+".xlsx");
			if(!ff.exists()){
				 ff.createNewFile();  
			}
			FileOutputStream fout = new FileOutputStream(ff);
			workbook.write(fout);
			fout.close();
			response.getWriter().write("ok");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public String importStuContest() throws IOException{
		
		List<StudentContest> list = MyExcel.readXlsx(excelFile,  3);
		System.out.println("list size():"+list.size());
		boolean b = adminService.updaStuContest(list);
		if(b){
			request.put("msg", "批量更新学生获奖情况成功!!");
		}else{
			request.put("msg", "批量更新学生获奖情况失败!!");
		}
		return "adminMainFrame";
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}
}
