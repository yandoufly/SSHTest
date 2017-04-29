package com.yjy.emp.entity;
import java.util.Date;

public class Emp {
	private Integer empno;
	private String username;
	private double salary;
	private Date hiredate;
	public Emp(){}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", username=" + username + ", salary=" + salary + ", hiredate=" + hiredate + "]";
	}
}
