package com.contest.entities;

import java.util.Date;

public class Teacher {
	private Integer id; 
	private Integer teacherId; 
	private String passwd;
	private String name; 
	private String sex;  
	private Date birthday; 
	private String profess; 
	private String telephone; 
	private String qq;   
	private String weixin;  
	private String profiles; 
	private int status;
	
	public Teacher() {
	}
	public Teacher(Integer teacherId, String passwd, String name, String sex, Date birthday, String profess,
			String telephone, String qq, String weixin, String profiles) {
		this.teacherId = teacherId;
		this.passwd = passwd;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.profess = profess;
		this.telephone = telephone;
		this.qq = qq;
		this.weixin = weixin;
		this.profiles = profiles;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getProfiles() {
		return profiles;
	}
	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherId=" + teacherId + ", passwd=" + passwd + ", name=" + name + ", sex="
				+ sex + ", birthday=" + birthday + ", profess=" + profess + ", telephone=" + telephone + ", qq=" + qq
				+ ", weixin=" + weixin + ", profiles=" + profiles + ", status=" + status + "]";
	}
}
