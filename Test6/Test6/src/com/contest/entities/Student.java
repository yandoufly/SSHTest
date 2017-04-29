package com.contest.entities;

import java.util.Date;

public class Student {
	private Integer id; 
	private Integer studentId; 
	private String name; 
	private String passwd;
	private String sex; 
	private Date birthday; 
	private String dept;
	private String profess;
	private String telephone;  
	private String qq;  
	private Integer status;
	
	public Student() {
	}
	public Student(Integer studentId, String name, String passwd, String sex, Date birthday, String dept,
			String profess, String telephone, String qq) {
		this.studentId = studentId;
		this.name = name;
		this.passwd = passwd;
		this.sex = sex;
		this.birthday = birthday;
		this.dept = dept;
		this.profess = profess;
		this.telephone = telephone;
		this.qq = qq;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getProfess() {
		return profess;
	}
	public void setProfess(String profess) {
		this.profess = profess;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
