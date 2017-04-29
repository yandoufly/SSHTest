package com.exam.action;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.exam.entities.Role;
import com.exam.entities.Student;
import com.exam.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("StudentAction")
public class StudentAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	private Student student;
	
	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;
	
	private List<Role> queryRole;
	
	@Resource
	private StudentService studentService;

	//未完成
	public String importStuExcel(){
		//1、获取excel文件
		if(userExcel != null){
			//是否是excel
			if(userExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
				//2、导入
				studentService.importStuExcel(userExcel, userExcelFileName);
			}
		}
		return "success";
	}
	
	//登录
	public String login(){
		System.out.println(student.getSnumber() +" ," + student.getSpwd());
		Student s = studentService.login(student.getSnumber(), student.getSpwd());
		
		if(s != null){
			ServletActionContext.getRequest().getSession().setAttribute("user", s);
			return "success";
		}
		request.put("msg", "输入有误");
		return "fail";
	}
	
	
	//显示所有用户
	public String showAllUser(){
		List<Student> studentList = studentService.showAllStudent();
		request.put("students", studentList);
		return "success";
	}
	
	//显示某个用户下的角色(可以另设)
	public String setRole(){
		//为哪个用户添加角色
		student = studentService.getStudentBySid(student.getSid());
		
		//显示所有角色
		List<Role> roleList = studentService.getAllRoles();
		
		Set<Role> roleSet = student.getRoles();
		
		for(Role role:roleSet){
			roleList.get(roleList.indexOf(role)).setChecked(true);
		}
		
		request.put("student", student);
		request.put("roleList", roleList);
		
		return "success";
	}
	
	//保存分配的角色
	public String saveRole(){
		Set<Role> roleSet = new HashSet<Role>();//声明一个SET
		
		roleSet.addAll(queryRole);//将集合存入SET为了去除空格
		
		roleSet.remove(null);//去除最后一个空格
		
		studentService.updateRole(student, roleSet);
		
		return "success";
	}
	
	
	public File getUserExcel() {
		return userExcel;
	}

	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}

	public String getUserExcelContentType() {
		return userExcelContentType;
	}

	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}

	public String getUserExcelFileName() {
		return userExcelFileName;
	}

	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
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

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

}
