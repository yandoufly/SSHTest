package com.yjy.scm.service;

import com.yjy.scm.entity.Page;

public interface BaseService<T> {
	//添加单个对象
	public int insertEntity(T entity) throws Exception;
	
	//修改单个对象
	public int updateEntity(T entity) throws Exception;
	
	//删除单个对象
	public int deleteEntity(T entity) throws Exception;
	
	//通过主键（数组）批量删除数据
	public int deleteList(String [] pks) throws Exception;
	
	//查询单个对象
	public T selectEntity(T entity);

	//通过关键字分页查询
	public Page<T> selectPage(Page<T> page); 
	
	//通过多条件分页查询(动态)
	public Page<T> selectPageUseDyc(Page<T> page); 
}
