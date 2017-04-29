package com.yjy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.entity.User;
import com.yjy.service.UserService;
import com.yjy.utils.PageBean;
import com.yjy.utils.SqlQueryUtil;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 获取“当前页”参数；(第一次访问当前页为null) 
		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || "".equals(currentPage.trim())){
			currentPage = "1";  	// 第一次访问，设置当前页为1;
		}
		int currPage = Integer.parseInt(currentPage); // 转换
		
		//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrentPage(currPage);
		
		//3. 调用service  
		userService.getUserByPage(pageBean); // 【pageBean已经被dao填充了数据】
		
		
		//4 保存pageBean对象，到request域中
		request.setAttribute("pageBean", pageBean);
		pageBean.getPageList();
		
		//6. 跳转 
		request.getRequestDispatcher("showAllUser.jsp").forward(request, response);
	}
}
