package com.exam.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SuperDao {

	@Resource
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Object addEntity(Object o){
		getSession().save(o);
		return o;
	}
	
	public Object getEntityById(Class c,Serializable id){
		return getSession().get(c, id);
	}
	
	
	public void deleteEntityById(Class c,Serializable id){
		Object o = getEntityById(c,id);
		getSession().delete(o);
	}
	
	public void updateEntity(Object o){
		getSession().update(o);
	}
	
	
	public List getAllEntity(Class c){
		return getSession().createQuery("from "+c.getName()).list();
	}
	
	
	public List getAllEntity(Class c,int begin,int pageSize){
		return getSession().createQuery("from "+c.getName()).setFirstResult(begin).setMaxResults(pageSize).list();
	}
	
	public  long  getEntityCount(Class c){
		return (Long)getSession().createQuery("select count(*) from "+c.getName()).uniqueResult();
	}
}
