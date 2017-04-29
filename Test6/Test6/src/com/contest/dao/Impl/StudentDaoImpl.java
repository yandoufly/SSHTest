package com.contest.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.StudentDao;
import com.contest.entities.Student;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public Student getStudentBySid(int studentId) {
		String hql = "from Student s where s.studentId=?";
		Query query = getSession().createQuery(hql).setParameter(0, studentId);
		Student student = (Student) query.uniqueResult();
		return student;
	}

	@Override
	public boolean insertStudent(Student student) {
		try {
			getSession().save(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> getListStudent(int status) {
		String hql = "from Student s where s.status=?";
		Query query = getSession().createQuery(hql).setParameter(0, status);
		return query.list();
	}

	@Override
	public boolean delStudent(int id) {
		Student student = (Student) getSession().get(Student.class, id);
		try {
			getSession().delete(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateStudent(Student student) {
		getSession().update(student);
	}

}
