package com.exam.entities;
/**
 * 考试
 */
public class Exam {

	private int examId; //编号
	private String examName; //考试的名称：比如 XXXXX期末考试
	private int examTime; //考试的时间：单位分钟
	private int examQuestionCount; //考试的题量;
	private int examTotalScore; //考试的总分;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}
	public int getExamQuestionCount() {
		return examQuestionCount;
	}
	public void setExamQuestionCount(int examQuestionCount) {
		this.examQuestionCount = examQuestionCount;
	}
	public int getExamTotalScore() {
		return examTotalScore;
	}
	public void setExamTotalScore(int examTotalScore) {
		this.examTotalScore = examTotalScore;
	}
	
}
