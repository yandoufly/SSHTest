package com.exam.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 试卷
 * @author student
 */
public class ExamPaper {
	
	private int epId; //试卷编号 
	private String startTime; //开考时间
	private String commitTime; //实际交卷时间
	private String state = "待考"; //试卷状态：待考、考试中、已完成
	private float score=0.0f; //考试的得分
	
	private Exam exam; //所属考试
	private Student student; //所属考生;
	
	List<StudentQuestionRecord> records; //这张试卷里的所有考题
	
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<StudentQuestionRecord> getRecords() {
		if(records==null){
			records = new ArrayList<StudentQuestionRecord>();
		}
		return records;
	}
	public void setRecords(List<StudentQuestionRecord> records) {
		this.records = records;
	}
	public String getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}
