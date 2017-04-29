package com.exam.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.exam.entities.Answer;
import com.exam.entities.ExamPaper;
import com.exam.entities.Question;
import com.exam.service.PaperService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("PaperAction")
public class PaperAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	
	private int paperId; //试卷id
	private int index; //当前第几题
	private List<Answer> answers; //这道题的答案
	
	@Resource
	private PaperService paperService;

	//开始考试
	public String beginDoQuestion(){
		//准备好试卷
		ExamPaper paper = paperService.createPaper(paperId,true);
		//根据index显示paper中的题
		showQuestionByIndexOnPaper(paper,index);

		return "success";
	}
	
	//继续答题
	public String continueQuestion(){
		//准备好试卷
		ExamPaper paper = paperService.createPaper(paperId,false);
		//根据index显示paper中的题
		showQuestionByIndexOnPaper(paper,index);

		return "success";
	}
	
	//下一题
	public String nextQuestion(){
		//记录本题所选答案
		ExamPaper paper = paperService.recordPaper(paperId, index, answers);
		//显示下一题
		if(index<paper.getExam().getExamQuestionCount()-1){
			index++;
		}
		//根据index显示paper中的题
		showQuestionByIndexOnPaper(paper,index);
		return "success";
	}
	
	//上一题
	public String preQuestion(){
		//记录本题所选答案
		ExamPaper paper = paperService.recordPaper(paperId, index, answers);
		//显示下一题
		if(index>0){
			index--;
		}
		//根据index显示paper中的题
		showQuestionByIndexOnPaper(paper,index);
		return "success";
	}
	
	//提交试卷
	public String commitExamPaper(){
		//调用service的提交试卷的方法
		ExamPaper paper = paperService.commitPaper(paperId, index, answers);
		
		request.put("score",paper.getScore());
		
		return "success";
	}

	//显示某张试卷上的第index道题
	private void showQuestionByIndexOnPaper(ExamPaper paper,int index){
		Question q = paper.getRecords().get(index).getQuestion();
		request.put("q", q);
		request.put("index", index);
		request.put("paperId",paperId);
		
		//显示这道题曾经选择的答案
		this.answers = paper.getRecords().get(index).getAnswers();
	}
	
	
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getPaperId() {
		return paperId;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

	public PaperService getPaperService() {
		return paperService;
	}

}
