package com.yjy.scm.dao;

import java.util.List;

import com.yjy.scm.entity.Page;

public interface BaseMapper<T> {
	//添加单个对象
	public int insertEntity(T entity);
	
	//修改单个对象
	public int updateEntity(T entity);
	
	//删除单个对象
	public int deleteEntity(T entity);
	
	//通过主键(数组) 批量删除数据
	public int deleteList(String[] pks);
	
	//查询单个对象
	public T selectEntity(T entity);
	
	//1.通过关键字分页查询数据列表
	public List<T> selectPageList(Page<T> page);
	//2.通过关键字分页查询，返回总记录数
	public Integer selectPageCount(Page<T> page);
	
	//1.通过关键字分页查询数据列表(动态)
	public List<T> selectPageListUseDyc(Page<T> page);
	//2.通过关键字分页查询，返回总记录数(动态)
	public Integer selectPageCountUseDyc(Page<T> page);
	
}
