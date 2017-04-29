package com.contest.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.TeacherDao;
import com.contest.entities.Teacher;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public Teacher getTeacherByTid(int teacherId) {
		String hql = "from Teacher t where t.teacherId=?";
		Query query = getSession().createQuery(hql).setParameter(0, teacherId);
		Teacher teacher = (Teacher) query.uniqueResult();
		return teacher;
	}

	@Override
	public boolean insertTeacher(Teacher teacher) {
		try {
			getSession().save(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Teacher> getListTeacher(int status) {
		String hql = "from Teacher t where t.status=?";
		Query query = getSession().createQuery(hql).setParameter(0, status);
		List<Teacher> list = query.list();
		return list;
	}

	@Override
	public boolean delTeacher(int id) {
		Teacher teacher = (Teacher) getSession().get(Teacher.class, id);
		try {
			getSession().delete(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		getSession().update(teacher);
	}

}
