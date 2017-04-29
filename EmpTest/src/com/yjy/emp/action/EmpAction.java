package com.yjy.emp.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjy.emp.entity.Emp;
import com.yjy.emp.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpAction {
	@Resource
	private EmpService empService;
	
	//查询所有的员工
	@RequestMapping("/findAllEmpMethod")
	public @ResponseBody List<Emp> findAllEmpMethod() throws Exception{
		//调用业务层，返回List对象
		List<Emp> empList = empService.findAllEmp();
//		for(Emp e : empList){
//			System.out.println(e);
//		}
		return empList;
	}
}
