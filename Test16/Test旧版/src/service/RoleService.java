package service;

import java.sql.CallableStatement;
import java.util.List;

import po.Module;
import po.Role;
import dao.RoleDao;

public class RoleService {
	
	RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	//根据id拿角色
	public Role getRoleById(int id){
		return (Role) roleDao.getEntityById(Role.class, id);
	}
	
	//添加角色
	public Role addRole(Role role){
		roleDao.addEntity(role);
		return role;
	}
	
	//删除角色
	public void deleteRole(Role role){
		roleDao.deleteEntityById(Role.class, role.getRid());
	}
	
	//显示所有角色
	public List<Role> getAllRole(){
		return roleDao.getAllEntity(Role.class);
	}
	
	//显示所有功能
	public List<Module> getAllModules(){
		return roleDao.getAllEntity(Module.class);
	}
	
	//保存一个角色的权限
	public Role updateRole(Role r,List<Module> modules){
		r = (Role) roleDao.getEntityById(Role.class, r.getRid());
		System.out.println(r.getModules().size());
		r.getModules().clear();//清除集合
		r.getModules().addAll(modules);
		System.out.println(r.getModules().size());
//		roleDao.updateEntity(r);这一步可以不要 
		
		return r;
	}
}
