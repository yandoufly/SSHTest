package util;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import po.Module;
import po.Role;
import po.Student;

public class Show extends TagSupport{

	String whatAreYoudoing;
	
	
	public int doStartTag() throws JspException {
		//谁
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Student s = (Student) request.getSession().getAttribute("user");
		//干什么
		System.out.println(whatAreYoudoing);
		//能不能干
		  //1获得用户的所有角色
			Set<Role> roles = s.getRoles();
		
		  //2获得这些角色的所有资源
		  Set<Module> allModule = new HashSet<Module>();	
			
			if(roles!=null){
				for(Role r:roles){
					allModule.addAll(r.getModules());
				}
			}
		
		  //3判断上述资源是否包含whatAreYoudoing
		  for(Module m:allModule){
			  if(whatAreYoudoing.equals(m.getModuleCode())){
				  return EVAL_BODY_INCLUDE;
			  }
		  }
		
		  return SKIP_BODY;
//		  return EVAL_BODY_INCLUDE;
	}


	public String getWhatAreYoudoing() {
		return whatAreYoudoing;
	}


	public void setWhatAreYoudoing(String whatAreYoudoing) {
		this.whatAreYoudoing = whatAreYoudoing;
	}
	
}
