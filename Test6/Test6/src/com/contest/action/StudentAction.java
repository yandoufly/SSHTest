package com.contest.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.contest.entities.Contest;
import com.contest.entities.Message;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.service.OtherService;
import com.contest.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("StudentAction")
public class StudentAction extends ActionSupport implements RequestAware,SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private StudentService studentService;
	@Resource
	private OtherService otherService;

	private int studentId;  //学生主键
	private int contestId;  //竞赛主键

	private Map<String, Object> request;
	private Map<String, Object> session;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getContestId() {
		return contestId;
	}
	public void setContestId(int contestId) {
		this.contestId = contestId;
	}
	//参加竞赛
	public String entryContest(){
			boolean b = studentService.entryContest(studentId,contestId);
			if(b){
				request.put("msg", "已成功报名该竞赛，请耐心等待通知");
			}else{
				request.put("msg", "您已经参加了该竞赛，不能再报名");
			}
		AllDatas();
		return "studentMainFrame";
	}
	
	//查看该学生的所有已参加的竞赛
	public String getAllSContest(){
		List<StudentContest> list = studentService.getAllSContest(studentId);
		request.put("listSContest", list);
		return "listSContest";
		
		
	}

	//返回主界面需要的数据
	public void AllDatas(){
		List<Contest> allContest = otherService.getAllContest();
		List<Message> allMessage = otherService.getAllMessage();
		request.put("allContest", allContest);
		request.put("allMessage", allMessage);
	}
	
	
	private Student student;
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
	
	//学生注册
	public String register(){
		System.out.println("student:" + student.getStudentId());
		student.setStatus(0); //设置为未激活
		boolean b = studentService.register(student);
		if(b){
			request.put("msg", "注册成功,请联系管理员激活账号！");
			return "login";
		}
		request.put("msg", "注册失败！");
		return "fail";
	}
	
	//修改个人信息
	
	public String updateStudent(){
		studentService.updateStudent(student);
		session.put("student", student);
		request.put("msg", "已成功修改个人信息");
		AllDatas();
		return "studentMainFrame";
	}
	
	//返回主页
	public String returnMainFrame(){
		AllDatas();
		return "studentMainFrame";
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
