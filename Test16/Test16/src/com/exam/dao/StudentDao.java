package com.exam.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.exam.entities.Student;

@Repository("StudentDao")
public class StudentDao extends SuperDao {

	public Student getStudentByNumber(String snumber) {
		String hql = "from Student s where s.snumber=:snumber";
		Query query = getSession().createQuery(hql).setParameter("snumber", snumber);
		Student student = (Student) query.uniqueResult();
		return student;
	}

}
