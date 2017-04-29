package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import po.Option;
import po.Question;
import service.QuestionService;

public class QuestionAction extends ActionSupport{

	Question question;

	//分页参数
	int begin;
	
	//添加一道题
	public String addQuestion(){
		questionService.addQuestion(question);
		return "success";
	}
	
	//显示所有考题
	public String showAllQuestion(){
		List<Question> list = questionService.getAllQuestion(begin,5);
		ServletActionContext.getRequest().setAttribute("list", list);
		//把考题的总数传到前台
		long count = questionService.getQuestionCount();
		ServletActionContext.getRequest().setAttribute("count",count);
		
		return "success";
	}
	
	//删除一道题
	public String deleteQuestion(){
		questionService.deleteQuestionById(question.getQid());
		return "success";
	}
	
	//显示一道题目的信息，以便于修改
	public String showQuestionInfo(){
		//拿完整的题目
		question = questionService.getQuestionById(question.getQid());
		return "success";
	}
	
	//修改题目信息
	public String updateQuestion(){
		questionService.updateQuestion(question);
		return "success";
	}
	
	//验证，至少有一个选项被设置为答案
	public void validateAddQuestion(){
		boolean flag = false;
		if(question.getOptions()!=null){
			for(Option o:question.getOptions()){
				if(o.getYes()){
					flag = true;
					//只要有一个选项被设为标准答案，则验证通过，跳出循环
					break;
				}
			}
		}
		
		if(!flag){
			this.addFieldError("error", "请至少设置一个正确答案");
		}
	}
	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	////////service/////////////
	QuestionService questionService;
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
}
