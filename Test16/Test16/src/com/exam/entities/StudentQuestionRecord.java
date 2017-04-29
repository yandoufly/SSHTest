package com.exam.entities;

import java.util.List;

/**
 * 学生做题的记录，用于记录那份试卷的哪个题目，学生的答案是什么
 *
 */
public class StudentQuestionRecord {

	private int sqrId; //编号
	
	private Question question; //哪道题
	private List<Answer> answers; //答案,怎么都会有4个答案
	
	private float score;
	
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
