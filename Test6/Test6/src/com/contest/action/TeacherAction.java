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
import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;
import com.contest.service.OtherService;
import com.contest.service.TeacherService;
import com.contest.utils.MyExcel;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("TeacherAction")
public class TeacherAction extends ActionSupport implements RequestAware,ServletResponseAware {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private OtherService otherService;
	@Resource
	private TeacherService teacherService;
	
	private Map<String, Object> request;
	private HttpServletResponse response;
	
	public String getAllContest(){
		//�õ�ȫ��������Ϣ
		List<Contest> allContest = otherService.getAllContest();
		request.put("allContest", allContest);
		return "showStuContest";
	}
	
	private int contestId;
	private Teacher teacher;
	
	public int getContestId() {
		return contestId;
	}
	public void setContestId(int contestId) {
		this.contestId = contestId;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	
	public String register(){
		System.out.println(teacher.getTeacherId());
		boolean b = teacherService.register(teacher);
		if(b){
			request.put("msg", "ע��ɹ�������ϵ����Ա�����˺�");
			return "login";
		}
		request.put("msg", "ע��ʧ�ܣ���");
		return "fail";
	}

	public String showStuContest(){
		List<StudentContest> allSContest = teacherService.getAllSContest(contestId);
		request.put("allSContest", allSContest);
		ObjectMapper mapper=new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(allSContest);
			
			System.out.println(result);
			
			response.setContentType("text/javascript");
			response.setCharacterEncoding("utf-8");
			
			response.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	private String excelFile;
	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}
	public String exportExcelStuContest(){
		System.out.println("test exportExcelStuContest");
		response.setContentType("text/html;charset=utf-8");
		XSSFWorkbook wb = new XSSFWorkbook();  
		XSSFSheet sheet = wb.createSheet();  
		
		//��sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		XSSFRow row = sheet.createRow((int) 0);
		XSSFCellStyle style = wb.createCellStyle();
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
		List<StudentContest> list = teacherService.getAllSContest(contestId);
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
			
			File ff = new File("D:\\upload\\contestNo-"+contestId+".xls");
			if(!ff.exists()){
				 ff.createNewFile();  
			}
			FileOutputStream fout = new FileOutputStream(ff);
			
			wb.write(fout);
			fout.close();
			response.getWriter().write("ok");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//��������ѧ���μӾ��������Ϣ
	public String importStuContest() throws IOException{
		List<StudentContest> list = MyExcel.readXlsx(excelFile,  3);
		boolean b = teacherService.updaStuContest(list);
		request.put("msg", "��������ѧ��������ɹ�!!");
		return "teacherMainFrame";
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
