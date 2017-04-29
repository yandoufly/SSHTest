package po;

import java.util.List;

/**
 * 学生做题的记录，用于记录那份试卷的哪个题目，学生的答案是什么
 * @author student
 *
 */
public class StudentQuestionRecord {

	int sqrId;
	//哪道题
	Question question;
	//答案,怎么都会有4个答案
	List<Answer> answers;
	
	float score;
	
	public int getSqrId() {
		return sqrId;
	}
	public void setSqrId(int sqrId) {
		this.sqrId = sqrId;
	}

	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
