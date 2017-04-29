package dao;

import java.util.List;

import javax.management.relation.Role;

import po.Student;

public class StudentDao extends SuperDao{
	
	//方法
	public Student getStudentByNumber(String number){
		List<Student> list = this.sessionFactory.getCurrentSession().createQuery("from Student s where s.snumber=:number").setParameter("number", number).list();
		if(list==null||list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}
	
//	//获得基本角色
//	public Role getBaseRole(){
//		this.getSessionFactory().getCurrentSession().get(Role.class, 1);
//	}
	
}
