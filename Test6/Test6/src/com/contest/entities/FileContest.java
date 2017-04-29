package com.contest.entities;

public class FileContest {
	private Integer id;
	private Contest contest; 
	private String filename;
	private String filepath;
	
	public FileContest() {
		super();
	}
	
	public FileContest(Contest contest, String filename, String filepath) {
		super();
		this.contest = contest;
		this.filename = filename;
		this.filepath = filepath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}
