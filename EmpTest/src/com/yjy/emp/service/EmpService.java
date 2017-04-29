package com.yjy.emp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjy.emp.dao.EmpDao;
import com.yjy.emp.entity.Emp;

@Service("empService")
public class EmpService {
	@Resource
	private EmpDao empDao;
	
	//查询所有员工
	public List<Emp> findAllEmp() throws Exception{
		return empDao.findAll();
	}
}
