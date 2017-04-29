package com.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.RoleDao;
import com.exam.entities.Module;
import com.exam.entities.Role;

@Service("RoleService")
public class RoleService {
	
	@Resource
	private RoleDao roleDao;

	//添加角色
	public void addRole(Role role) {
		roleDao.addEntity(role);
	}

	//得到全部角色
	public List<Role> getAllRole() {
		return roleDao.getAllEntity(Role.class);
	}

	//删除该角色
	public void deleteRole(Role role) {
		roleDao.deleteEntityById(Role.class, role.getRid());
	}

	//根据id 查询出该角色
	public Role getRoleById(int rid) {
		return (Role) roleDao.getEntityById(Role.class, rid);
	}

	//显示所有功能
	public List<Module> getAllModules() {
		return roleDao.getAllEntity(Module.class);
	}

	//保存一个角色的权限
	public void updateRole(Role role, List<Module> modules) {
		role = (Role) roleDao.getEntityById(Role.class, role.getRid());
		System.out.println(role.getModules().size());
		
		role.getModules().clear();//清除集合
		role.getModules().addAll(modules);
		System.out.println(role.getModules().size());
		roleDao.updateEntity(role); 
		
	}

}
