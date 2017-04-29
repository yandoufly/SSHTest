package com.exam.utils;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.exam.entities.Module;
import com.exam.entities.Role;
import com.exam.entities.Student;

/**
 * 自定义标签，用于权限管理设置
 */
public class ShowTag extends TagSupport {
	
	private String whatAreYoudoing;

	@Override
	public int doStartTag() throws JspException {
		
		//谁
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Student student = (Student) request.getSession().getAttribute("user");
		
		//干什么
		if(student != null){
			System.out.println("student:" + student.getSname());
			//能不能干
			//1.获取用户所有角色
			Set<Role> roles = student.getRoles();
			
			//2.获得这些角色的所有功能
			Set<Module> allModule = new HashSet<Module>();
			if(roles != null){
				for(Role r : roles){
					allModule.addAll(r.getModules());
				}
			}
			
			//3.判断这些功能是否包含whatAreYoudoing
			for(Module m : allModule){
				if(whatAreYoudoing.equals(m.getModuleCode())){
					return EVAL_BODY_INCLUDE; 
				}
			}
		}
		
		return SKIP_BODY;
	}
	
	public void setWhatAreYoudoing(String whatAreYoudoing) {
		this.whatAreYoudoing = whatAreYoudoing;
	}
	public String getWhatAreYoudoing() {
		return whatAreYoudoing;
	}
}
