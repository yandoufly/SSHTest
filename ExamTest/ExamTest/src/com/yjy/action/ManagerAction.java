package com.yjy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yjy.dao.ManagerDao;
import com.yjy.model.Manager;

public class ManagerAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	
	private ManagerDao managerDao=new ManagerDao();
	private Manager manager;
	private String error;
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String login()throws Exception{
		HttpSession session=request.getSession();
		Manager currentUser=managerDao.login(manager);
		if(currentUser==null){
			error="用户名或密码错误";
			return ERROR;
		}else{
			session.setAttribute("currentUser", currentUser);
			return SUCCESS;
		}
	}
	
	public String logout()throws Exception{
		request.getSession().invalidate();
		return "logout";
	}

}
