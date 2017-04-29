package action;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import po.Role;
import po.Student;

import service.StudentService;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class StudentAction extends ActionSupport{
	//上传的文件
	File upload;
	//上传的文件名
	String uploadFileName;
	
	Student student;
	
	List<Role> queryRole;
	/**
	 * 导入学生信息
	 * @return
	 */
	public String addStudent(){
		
		//读取文件的内容
		try {
			Workbook book = Workbook.getWorkbook(upload);
			Sheet sheet = book.getSheet(0);
			
			int r = sheet.getRows();
			for(int i=1;i<r;i++){
				Student s = new Student();
				s.setSname(sheet.getCell(0,i).getContents());
				s.setSnumber(sheet.getCell(1,i).getContents());
				s.setSpwd("1");
				studentService.addStudent(s);
				System.out.println(sheet.getCell(0,i).getContents()+" "+sheet.getCell(1,i).getContents());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "success";
	}
	
	/**
	 * 登录
	 */
	public String login(){
		Student s = studentService.login(student.getSnumber(), student.getSpwd());
		if(s!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user", s);
			return "success";
		}else{
			return "faild";
		}
	}
	
	/**
	 * 
	 * 
	 * 显示所有用户
	 * @return
	 */
	public String showAllUser(){
		
		List<Student> studentList = studentService.showAllStudent();

		ServletActionContext.getRequest().setAttribute("students", studentList);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * 显示某个用户下的角色(可以另设)
	 * @return
	 */
	public String setRole(){
		
		//为哪个用户添加角色
		student = studentService.getStudentById(student.getSid());
		
		//显示所有角色
		List<Role> roleList = studentService.getAllRoles();
		
		Set<Role> roleSet = student.getRoles();
		
		for(Role role:roleSet){
			
			roleList.get(roleList.indexOf(role)).setChecked(true);
		}
		
		ServletActionContext.getRequest().setAttribute("student", student);
		ServletActionContext.getRequest().setAttribute("roleList", roleList);
			
		return SUCCESS;
	}


	/**
	 * 
	 * 保存分配的角色
	 * @return
	 */
	public String saveRole(){
		
		Set<Role> roleSet = new HashSet<Role>();//声明一个SET
		
		roleSet.addAll(queryRole);//将集合存入SET为了去除空格
		
		roleSet.remove(null);//去除最后一个空格
		
		studentService.updateRole(student, roleSet);
		
		
		//获取所有角色
//		List<Role> moduleList = studentService.getAllRoles();
		
		return SUCCESS;

	}
	
	

	StudentService studentService;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Role> getQueryRole() {
		return queryRole;
	}

	public void setQueryRole(List<Role> queryRole) {
		this.queryRole = queryRole;
	}
	
}
