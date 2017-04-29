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

	private int studentId;  //ѧ������
	private int contestId;  //��������

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
	//�μӾ���
	public String entryContest(){
			boolean b = studentService.entryContest(studentId,contestId);
			if(b){
				request.put("msg", "�ѳɹ������þ����������ĵȴ�֪ͨ");
			}else{
				request.put("msg", "���Ѿ��μ��˸þ����������ٱ���");
			}
		AllDatas();
		return "studentMainFrame";
	}
	
	//�鿴��ѧ���������Ѳμӵľ���
	public String getAllSContest(){
		List<StudentContest> list = studentService.getAllSContest(studentId);
		request.put("listSContest", list);
		return "listSContest";
		
		
	}

	//������������Ҫ������
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
	
	//ѧ��ע��
	public String register(){
		System.out.println("student:" + student.getStudentId());
		student.setStatus(0); //����Ϊδ����
		boolean b = studentService.register(student);
		if(b){
			request.put("msg", "ע��ɹ�,����ϵ����Ա�����˺ţ�");
			return "login";
		}
		request.put("msg", "ע��ʧ�ܣ�");
		return "fail";
	}
	
	//�޸ĸ�����Ϣ
	
	public String updateStudent(){
		studentService.updateStudent(student);
		session.put("student", student);
		request.put("msg", "�ѳɹ��޸ĸ�����Ϣ");
		AllDatas();
		return "studentMainFrame";
	}
	
	//������ҳ
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
