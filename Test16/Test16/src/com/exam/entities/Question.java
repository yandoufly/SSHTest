package com.exam.entities;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private int qid; //编号
	private String content; //题目的内容
	
	private List<Option> options; //一个题目下有多个选项

	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Option> getOptions() {
		if(options==null){
			options=new ArrayList<Option>();
		}
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public boolean equals(Object obj) {
		Question other = (Question) obj;
		return this.qid == other.getQid();
	}
	
	@Override
	public int hashCode() {
		return qid;
	}
	
}
