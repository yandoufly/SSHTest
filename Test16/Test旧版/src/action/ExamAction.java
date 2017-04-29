package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import po.Exam;
import po.ExamPaper;
import po.Question;
import po.Student;
import service.ExamService;

import com.opensymphony.xwork2.ActionSupport;

import dao.SuperDao;

public class ExamAction extends ActionSupport{
	
	Exam exam;
	
	//发起一次考试
	public String addExam(){
		examService.addExam(exam);
		return SUCCESS;
	}
	
	//显示我的考试
	public String showAllExam(){
		List<Exam> list = examService.getAllExam();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "success";
	}
	
	//生成试卷
	public String createExamPaper(){
		
		//获得所属的考试对象
		Exam e = examService.getExamById(exam.getExamId());
		//获得所属的学生对象
		Student s = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		//生的试卷
//		try {
		ExamPaper paper = examService.createExamPaper(e, s);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			ServletActionContext.getRequest().setAttribute("error", e1.getMessage());
//			return "error";
//		}
		if(paper!=null){
			return "success";
		}else{
			ServletActionContext.getRequest().setAttribute("error","已经生成过试卷了");
			return "error";
		}
		
		
	}
	
	/**
	 * 显示我的试卷
	 */
	public String showMyPaper(){
		//获得当前用户
		Student s = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
		//获得这个用户的所有试卷
		List<ExamPaper> list = examService.getPaperByUserId(s.getSid());
		
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "success";
	}
	

	ExamService examService;

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ExamService getExamService() {
		return examService;
	}

}
