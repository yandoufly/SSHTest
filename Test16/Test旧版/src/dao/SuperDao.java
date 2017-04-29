package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * 所有Dao的父类
 * @author student
 *
 */
public class SuperDao {

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//添加一个实体
	public Object addEntity(Object o){
		sessionFactory.getCurrentSession().save(o);
		return o;
	}
	
	//根据id拿实体
	public Object getEntityById(Class c,Serializable id){
		return sessionFactory.getCurrentSession().get(c, id);
	}
	
	
	//删除一个实体
	public void deleteEntityById(Class c,Serializable id){
		Object o = getEntityById(c,id);
		sessionFactory.getCurrentSession().delete(o);
	}
	
	//修改一个实体
	public void updateEntity(Object o){
		sessionFactory.getCurrentSession().update(o);
	}
	
	
	//获得所有实体
	public List getAllEntity(Class c){
		return sessionFactory.getCurrentSession().createQuery("from "+c.getName()).list();
	}
	
	
	//获得所有实体(分页)
	public List getAllEntity(Class c,int begin,int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from "+c.getName()).setFirstResult(begin).setMaxResults(pageSize).list();
	}
	
	//获得所有实体的总数(分页)
	public  long  getEntityCount(Class c){
		return (Long)sessionFactory.getCurrentSession().createQuery("select count(*) from "+c.getName()).uniqueResult();
	}
}
