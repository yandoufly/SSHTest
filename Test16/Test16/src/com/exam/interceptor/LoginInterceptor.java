package com.exam.interceptor;

import org.apache.struts2.ServletActionContext;

import com.exam.entities.Student;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		//检查登陆与否
		Student student = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(student==null){
			return "login";
		}
		//让Action正常执行
		String s = arg0.invoke();
		return s;
	}

}
