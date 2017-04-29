package com.exam.entities;

public class Answer {
	
	private int answerId;
	private String mark;//A B C D
	private boolean yes;
	
	public Answer(String mark) {
		this.mark = mark;
	}
	public Answer() {
		// TODO Auto-generated constructor stub
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public boolean getYes() {
		return yes;
	}
	public void setYes(boolean yes) {
		this.yes = yes;
	}
}
