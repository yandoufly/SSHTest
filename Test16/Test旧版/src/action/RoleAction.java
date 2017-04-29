package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import po.Module;
import po.Role;
import service.RoleService;

public class RoleAction {
	
	Role role;
	
	List<Module> list;
	
	public String addRole(){
		roleService.addRole(role);
		return "success";
	}
	
	public String deleteRole(){
		roleService.deleteRole(role);
		return "success";
	}
	
	public String showAllRole(){
		List<Role> list = roleService.getAllRole();
		ServletActionContext.getRequest().setAttribute("list", list);
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
//		for(Module m:set){
//			list.get(list.indexOf(m)).setChecked(true);
//		}
		
		for(Module m:set){
			
			//这个已有的功能在所有功能的哪个位置
			int index = list.indexOf(m);
			//在所有的功能中找到这个已有的功能
			Module mod = list.get(index);
			//把他的check属性设为true
			mod.setChecked(true);
		}
		
		
		ServletActionContext.getRequest().setAttribute("role", r);
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "success";
	}
	
	//保存角色的权限
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
	
	
	RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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
	
}
