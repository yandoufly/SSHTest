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
	
	//���ѧ��δ������˺�
	public String checkStudent(){
		List<Student> allNoStatusStudents = adminService.getAllNoStatusStudent();
		request.put("allNoStatusStudents", allNoStatusStudents);
		return "allNoStatusStudents";
	}

	//����ѧ��
	public String activeStudent(){
		boolean b = adminService.activeStudent(id);
		if(b){
			request.put("msg", "�Ѽ����ѧ���˺�");
			return "adminMainFrame";
		}
		
		request.put("msg", "�����ѧ���˺�ʧ��");
		return checkStudent();
		
	}
	
	//ɾ����ѧ��
	public String delStudent(){
		boolean b = adminService.delStudent(id);
		if(b){
			request.put("msg", "��ɾ����ѧ��");
			return "adminMainFrame";
		}
		request.put("msg", "ɾ����ѧ���˺�ʧ��");
		return checkStudent();
	}
	
	//����ѧ������
	public String resetStuPasswd(){
		boolean b = adminService.resetStuPasswd(id);
		if(b){
			request.put("msg", "�����ø�ѧ������");
		}else{
			request.put("msg", "���ø�ѧ������ʧ��");
		}
		return "adminMainFrame";
	}
	
	//ע��ѧ���˺�
	public String cancelStudent(){
		boolean b = adminService.cancelStudent(id);
		if(b) {
			request.put("msg", "�ѳɹ�ע����ѧ���˺�");
		}else{
			request.put("msg", "�ѳɹ�ע����ѧ���˺�");
		}
		return "adminMainFrame";
	}
	
	
	//��˽�ʦ�˺�
	public String checkTeacher(){
		List<Teacher> allNoStatusTeachers = adminService.getAllNoStatusTeacher();
		request.put("allNoStatusTeachers", allNoStatusTeachers);
		return "allNoStatusTeachers";
	}
	
	//�����ʦ�˺�
	public String activeTeacher(){
		boolean b = adminService.activeTeacher(id);
		if(b){
			request.put("msg", "�Ѽ���ý�ʦ�˺�");
			return "adminMainFrame";
		}
		
		request.put("msg", "����ý�ʦ�˺�ʧ��");
		return checkTeacher();
	}
	
	//ɾ���ý�ʦ�˺�
	public String delTeacher(){
		boolean b = adminService.delTeacher(id);
		if(b){
			request.put("msg", "��ɾ���ý�ʦ");
			return "adminMainFrame";
		}
		request.put("msg", "ɾ���ý�ʦ�˺�ʧ��");
		return checkTeacher();
	}
	
	//���ý�ʦ����
	public String resetTeaPasswd(){
		boolean b = adminService.resetTeaPasswd(id);
		if(b){
			request.put("msg", "�����øý�ʦ����");
		}else{
			request.put("msg", "���øý�ʦ����ʧ��");
		}
		return "adminMainFrame";
	}
	
	//ע����ʦ�˺�
	public String cancelTeacher(){
		boolean b = adminService.cancelTeacher(id);
		if(b){
			request.put("msg", "�ѳɹ�ע���ý�ʦ�˺�");
		}else{
			request.put("msg", "����ʧ��");
		}
		return "adminMainFrame";
	}
	
	//�鿴��ʦ��������
	public String lookTeacher(){
		Teacher teacher = adminService.lookTeacher(id);
		if(teacher != null){
			request.put("teacher", teacher);
			return "lookTeacher";
		}
		request.put("msg", "����ʧ�ܣ�����");
		return "adminMainFrame";
	}
	
	//��˽�ʦ������δ�����
	public String checkTContest(){
		List<Contest> allNoDisplayContest = adminService.getAllTContest();
		request.put("allNoDisplayContest", allNoDisplayContest);
		return "allNoDisplayContest";
	}
	
	//ʹ��������ʾ��ҳ����
	public String activeContest(){
		boolean b = adminService.activeContest(id);
		if(b){
			request.put("msg", "�ѽ��þ�����Ϣ��ʾ��ҳ����");
			return "adminMainFrame";
		}
		request.put("msg", "����ʧ�ܣ���");
		return checkTContest();
	}
	
	//ɾ���þ�����Ϣ
	public String delContest(){
		boolean b = adminService.delContest(id);
		if(b){
			request.put("msg", "�ѽ��þ�����Ϣɾ��");
			return "adminMainFrame";
		}
		request.put("msg", "����ʧ�ܣ���");
		return checkTContest();
	}
	
	//�õ�ȫ������
	public String getAllContest(){
		List<Contest> allContest = adminService.getAllContest();
		request.put("allContest", allContest);
		return "listContest";
	}
	
	
	//��˽�ʦ������δ��������Ź���
	public String checkTMessage(){
		List<Message> allNoDisplayMessage = adminService.getAllTMessage();
		request.put("allNoDisplayMessage", allNoDisplayMessage);
		return "allNoDisplayMessage";
	}
	
	//�����ʦ���������Ź���
	public String activeMessage(){
		boolean b = adminService.activeMessage(id);
		if(b){
			request.put("msg", "�ѽ������Ź�����ʾ��ҳ����");
			return "adminMainFrame";
		}
		request.put("msg", "����ʧ�ܣ���");
		return checkTMessage();
	}
	
	//ɾ���þ�����Ϣ
	public String delMessage(){
		boolean b = adminService.delMessage(id);
		if(b){
			request.put("msg", "�ѽ������Ź���ɾ��");
			return "adminMainFrame";
		}
		request.put("msg", "����ʧ�ܣ���");
		return checkTContest();
	}
	
	private String excelFile;
	public String getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}
	//��������ѧ���˺�
	public String importListStudent() throws IOException {
		List<Student> list = MyExcel.readXlsx(excelFile,  1);
		boolean b = adminService.insertListStudent(list);
		if(b){
			request.put("msg", "����ѧ���ɹ�");
		}else{
			request.put("msg", "����ѧ��ʧ��");
		}
		return "adminMainFrame";
		
	}

	//��������ѧ���˺�
	public String importListTeacher() throws IOException {
		List<Teacher> list = MyExcel.readXlsx(excelFile, 2);
		boolean b = adminService.insertListTeacher(list);

		if(b){
			request.put("msg", "������ʦ�ɹ�");
		}else{
			request.put("msg", "������ʦʧ��");
		}
		return "adminMainFrame";
		
	}
	
	private int contestId;
	public void setContestId(int contestId) {
		this.contestId = contestId;
	}
	//��ʾ����Ϣ
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
	
	//����ѧ������Ϣ���
	public String exportExcelStuContest(){
		System.out.println("test exportExcelStuContest");
		response.setContentType("text/html;charset=utf-8");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		//��sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		XSSFRow row = sheet.createRow((int) 0);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("���");
		cell.setCellStyle(style);  
		
		cell = row.createCell(1);
		cell.setCellValue("�������");
		cell.setCellStyle(style);  
		
		cell = row.createCell(2);
		cell.setCellValue("��������");
		cell.setCellStyle(style);  
		
		cell = row.createCell(3);
		cell.setCellValue("ѧ��ѧ��");
		cell.setCellStyle(style);  
		
		cell = row.createCell(4);
		cell.setCellValue("ѧ������");
		cell.setCellStyle(style);  

		cell = row.createCell(5);
		cell.setCellValue("���Ƚ�");
		cell.setCellStyle(style);  
		
		// �õ�ʵ�ʵ�ֵ
		List<StudentContest> list = adminService.getStuContestByconstestId(contestId);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			StudentContest studentContest = (StudentContest) list.get(i);
			// ���Ĳ���������Ԫ�񣬲�����ֵ
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
			request.put("msg", "��������ѧ��������ɹ�!!");
		}else{
			request.put("msg", "��������ѧ�������ʧ��!!");
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
