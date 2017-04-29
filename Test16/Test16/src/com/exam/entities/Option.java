package com.exam.entities;

public class Option {
	
	private int oid;
	private String content;//选项内容
	private String mark;//A B C D
	private boolean yes;//这个选项是否是正确答案

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
