package com.yjy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjy.dao.EmployeeDao;
import com.yjy.entities.Employee;

@Service("employeeService")
public class EmployeeService {
	
	@Resource
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public boolean lastNameIsValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	public List<Employee> getAll(){
		List<Employee> employees = employeeDao.getAll();
//		employees.clear();
		return employees;
	}

	public Employee get(Integer id) {
		return employeeDao.get(id);
	}

	/**
	 * µÇÂ¼
	 * @param employee
	 * @return boolean
	 */
	public boolean login(Employee employee) {
		Employee e = employeeDao.get(employee.getId());
		if(e!=null && e.getPassword().equals(employee.getPassword())){
			return true;
		}
		return false;
	}
	
}
