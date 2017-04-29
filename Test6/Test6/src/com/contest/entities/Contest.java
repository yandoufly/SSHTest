package com.contest.entities;

import java.util.Date;

public class Contest {
	private Integer id;
	private String title; 
	private String grade; 
	private String organiser; 
	private Date startTime; 
	private Date endRegTime; 
	private String content;  
	private int isDisplay;
	
	public Contest() {
	}
	public Contest(String title, String grade, String organiser, Date startTime, Date endRegTime, String content,
			int isDisplay) {
		this.title = title;
		this.grade = grade;
		this.organiser = organiser;
		this.startTime = startTime;
		this.endRegTime = endRegTime;
		this.content = content;
		this.isDisplay = isDisplay;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getOrganiser() {
		return organiser;
	}
	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndRegTime() {
		return endRegTime;
	}
	public void setEndRegTime(Date endRegTime) {
		this.endRegTime = endRegTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	} 
}
