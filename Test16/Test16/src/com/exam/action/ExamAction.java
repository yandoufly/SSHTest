package com.exam.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.exam.entities.Exam;
import com.exam.entities.ExamPaper;
import com.exam.entities.Student;
import com.exam.service.ExamService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ExamAction")
public class ExamAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	
	private Exam exam;
	
	@Resource
	private ExamService examService;
	
	//发起一次考试
	public String addExam(){
		examService.addExam(exam);
		return "success";
	}
	
	//显示我的考试
	public String showAllExam(){
		List<Exam> list = examService.getAllExam();
		request.put("list", list);
		return "success";
	}
	
	//生成试卷
	public String createExamPaper(){

		//获得所属的考试对象
		Exam e = examService.getExamById(exam.getExamId());
		
		System.out.println("考试对象：" + e.getExamName());
		//获得所属的学生对象
		Student s = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
		System.out.println("学生学号:"+s.getSnumber());
		//生的试卷
		ExamPaper paper = examService.createExamPaper(e, s);
		System.out.println("ccccccccccccccc");
		if(paper!=null){
			System.out.println("生成试卷成功！！");
			return "success";
		}else{
			request.put("msg","已经生成过试卷了");
			return "error";
		}
	}
	
	//显示我的试卷
	public String showMyPaper(){
		//获得当前用户
		Student s = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
		//获得这个用户的所有试卷
		List<ExamPaper> list = examService.getPaperByUserId(s.getSid());
		
		request.put("list", list);
		
		return "success";
	}

	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
	
	
}
