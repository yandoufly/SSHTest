package com.contest.entities;

import java.util.Date;

public class Message {
	private Integer id;
	private String title;
	private String content;
	private Date createTime;
	private int isDisplay;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", isDisplay=" + isDisplay + "]";
	} 
}
