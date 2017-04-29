package com.yjy.scm.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	public void init() throws ServletException {
		// Put your code here
		Map<String,Object> sysParamMap =new HashMap<String,Object>();
		
		Map<String,Object> supTypeMap =new HashMap<String,Object>();
		supTypeMap.put("1", "一级供应商");
		supTypeMap.put("2", "二级供应商");
		supTypeMap.put("3", "三级供应商");
		
		sysParamMap.put("supType", supTypeMap);

		Map<String,Object> goodsColorMap =new HashMap<String,Object>();
		goodsColorMap.put("1","红色");
		goodsColorMap.put("2","绿色");
		goodsColorMap.put("3","蓝色");
		sysParamMap.put("goodsColor", goodsColorMap);
		
		this.getServletContext().setAttribute("sysParam", sysParamMap);
		System.out.println("-------------------系统参数加载成功---------------------");
	}
}
