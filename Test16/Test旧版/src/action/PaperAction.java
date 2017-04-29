package action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import po.Answer;
import po.ExamPaper;
import po.Question;
import po.StudentQuestionRecord;
import service.PaperService;
import util.PaperAutoCommitThread;

/**
 * 处理答题的过程
 * @author student
 *
 */
public class PaperAction {
	
	//试卷id
	int paperId;
	//当前第几题
	int index;
	
	//这道题的答案
	List<Answer> answers;
	

	//开始答题
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
		
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("score",paper.getScore());
		
		return "success";
	}
	
	
	//显示某张试卷上的第index道题
	private void showQuestionByIndexOnPaper(ExamPaper paper,int index){
		Question q = paper.getRecords().get(index).getQuestion();
		ServletActionContext.getRequest().setAttribute("q", q);
		ServletActionContext.getRequest().setAttribute("index", index);
		ServletActionContext.getRequest().setAttribute("paperId",paperId);
		//显示这道题曾经选择的答案
		this.answers = paper.getRecords().get(index).getAnswers();
	}
	

	PaperService paperService;
	
	public PaperService getPaperService() {
		return paperService;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
