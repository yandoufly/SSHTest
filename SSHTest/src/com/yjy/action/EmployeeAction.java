package com.yjy.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.yjy.entities.Employee;
import com.yjy.service.DepartmentService;
import com.yjy.service.EmployeeService;

@Controller("employeeAction")
public class EmployeeAction extends ActionSupport implements RequestAware,
 ModelDriven<Employee>, Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private EmployeeService employeeService;

	@Resource
	private DepartmentService departmentService;
	
	

	private Integer id;
	private InputStream inputStream;
	private Employee employee;
	

	public String list() {
		request.put("employees", employeeService.getAll());
		return "list";
	}
	
	//µÇÂ½
	public String login(){
		System.out.println("SSSSSSSSSSS");
		boolean b = employeeService.login(employee);
		if(b){
			return "ok";
		}
		return "index";
	}

	

	public String delete() {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	public String input(){
		request.put("departments", departmentService.getAll());
		return INPUT;
	}
	
	public void prepareInput(){
		if(id != null){
			model = employeeService.get(id);
		}
	}
	
	public String save(){
		if(id == null){
			model.setCreateTime(new Date());			
		}
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Employee();
		}else{
			model = employeeService.get(id);
		}
	}
	
	private String lastName;
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String validateLastName() throws UnsupportedEncodingException{
		if(employeeService.lastNameIsValid(lastName)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8")); 
		}else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8")); 
		}
		
		return "ajax-success";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {}

	private Employee model;
	
	@Override
	public Employee getModel() {
		return model;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}
}
