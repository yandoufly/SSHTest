package com.yjy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjy.dao.DepartmentDao;
import com.yjy.entities.Department;

@Service("departmentService")
public class DepartmentService {
	@Resource
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
	
}
