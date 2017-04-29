package com.exam.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.exam.entities.Option;
import com.exam.entities.Question;
import com.exam.service.QuestionService;
import com.exam.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("QuestionAction")
public class QuestionAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	
	Question question; 
	private String currentPage; //当前页码
	
	private Map<String, Object> request;
	
	@Resource
	private QuestionService questionService;
	
	
	//添加题目
	public String addQuestion(){
		questionService.addQuestion(question);
		return "success";
	}
	//验证，至少有一个选项被设置为答案
	public void validateAddQuestion(){
		if(question.getContent()==null || "".equals(question.getContent())){
			this.addFieldError("error", "问题不能为空");
		}
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
	
	//删除题目
	public String deleteQuestion(){
		questionService.deleteQuestionById(question.getQid());
		return "success";
	}
	
	

	//得到题目信息
	public String showQuestionInfo(){
		System.out.println("aaaaaaaaaxxxxxxxxxx");
		//拿完整的题目
		question = questionService.getQuestionById(question.getQid());
		return "success";
	}
	
	//修改题目信息
	public String updateQuestion(){
		questionService.updateQuestion(question);
		return "success";
	}
	
	

	//得到题目 的分页数据
	public String showPageQuestion(){
		System.out.println("xxxxsssssssssssss");
		try {
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = currentPage;
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 转换
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<Question> pageBean = new PageBean<Question>();
			pageBean.setCurrentPage(currentPage);
			
			//3. 调用service  
			questionService.getPageQuestion(pageBean); //【pageBean已经被dao填充了数据】
			
			//4. 保存pageBean对象，到request域中
			request.put("pageBean", pageBean);
			System.out.println("xxxxxxxxxxxxxxxxxx");
			System.out.println("pageBean:" + pageBean.getPageData().size());
			
			
		} catch (Exception e) {
			// 出现错误，跳转到错误页面；给用户友好提示
			System.out.println(e.getMessage());
			System.out.println("zzzzzzzzzz");
		}
		//5. 跳转 
		return "showPageQuestion";
	}
	

	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}


	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
}
