package com.exam.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.exam.entities.Module;
import com.exam.entities.Role;
import com.exam.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("RoleAction")
public class RoleAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	
	private Role role;
	
	private List<Module> list;
	
	@Resource
	private RoleService roleService;

	public String addRole(){
		roleService.addRole(role);
		return "success";
	}
	
	public String showAllRole(){
		List<Role> list = roleService.getAllRole();
		request.put("list", list);
		return "success";
	}
	
	
	public String deleteRole(){
		roleService.deleteRole(role);
		return "success";
	}
	
	//给角色设置功能权限
	public String setRoleModules(){
		//哪个角色?
		Role r = roleService.getRoleById(role.getRid());
		//当前系统的所有功能
		List<Module> list = roleService.getAllModules();
		//这个角色已有哪些功能
		Set<Module> set = r.getModules();
		for(Module m:set){
			list.get(list.indexOf(m)).setChecked(true);
		}

		for(Module m : set){
			//这个已有的功能在所有功能的哪个位置
			int index = list.indexOf(m);
			//在所有的功能中找到这个已有的功能
			Module mod = list.get(index);
			//把他的check属性设为true
			mod.setChecked(true);
		}
		
		request.put("role", r);
		request.put("list", list);
		
		return "success";
	}
	
	public String saveRoleModules(){
		System.out.println(list.size());
		//给list去除null
		if(list!=null){
			while(list.contains(null)){
				list.remove(null);
			}
		}
		
		//保存角色的功能
		roleService.updateRole(role, list);
		
		return "success";
	}
	
	
	
	
	
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Module> getList() {
		return list;
	}
	public void setList(List<Module> list) {
		this.list = list;
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

}
