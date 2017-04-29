package com.contest.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.contest.entities.Admin;
import com.contest.entities.Contest;
import com.contest.entities.Message;
import com.contest.entities.Student;
import com.contest.entities.Teacher;
import com.contest.service.AdminService;
import com.contest.service.OtherService;
import com.contest.service.StudentService;
import com.contest.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("LoginAction")
public class LoginAction extends ActionSupport implements SessionAware,RequestAware{
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private TeacherService teacherService;
	
	@Resource
	private StudentService studentService;
	@Resource
	private OtherService otherService;
	

	private int id;
	private String passwd;
	private int type;

	private Map<String, Object> session;
	private Map<String, Object> request;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String login(){
		if(type == 0){
			//����Ա��¼
			Admin admin = adminService.login(id, passwd);
			if(admin != null){
				session.put("admin", admin);
				return "adminMainFrame";
			}
		}else if(type == 1){
			//��ʦ��¼
			System.out.println(id + " sssssssss " + passwd);
			Teacher teacher = teacherService.login(id, passwd);
			if(teacher != null){
				if(teacher.getStatus() == 1){
					session.put("teacher", teacher);
					return "teacherMainFrame";
				}else{
					request.put("msg", "�˺�δ������ܵ�¼����");
					return "login";
				}
			}
		}else{
			//ѧ����¼
			Student student = studentService.login(id, passwd);
			if(student != null){
				if(student.getStatus() == 1){
					session.put("student", student);
					
					List<Contest> allContest = otherService.getAllContest();
					List<Message> allMessage = otherService.getAllMessage();
					request.put("allContest", allContest);
					request.put("allMessage", allMessage);
					return "studentMainFrame";
				}else{
					request.put("msg", "�˺�δ������ܵ�¼����");
					return "login";
				}
			}
		}
		request.put("msg", "�û��˺Ż����벻��ȷ������������");
		return "login";
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
}
