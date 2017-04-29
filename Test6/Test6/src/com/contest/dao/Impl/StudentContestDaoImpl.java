package com.contest.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.StudentContestDao;
import com.contest.entities.Contest;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;

@Repository("studentContestDao")
public class StudentContestDaoImpl extends BaseDao implements StudentContestDao {

	@Override
	public void addStudentContest(StudentContest studentContest) {
		getSession().save(studentContest);
	}
	
	@Override
	public StudentContest getSContestBySid_Cid(Student student, Contest contest) {
		String hql = "from StudentContest sc where sc.student=? and sc.contest=?";
		Query query = getSession().createQuery(hql)
				.setParameter(0, student)
				.setParameter(1, contest);
		return (StudentContest) query.uniqueResult();
	}
	@Override
	public List<StudentContest> getAllSContest(Student student) {
		String hql = "from StudentContest sc "
				+ "left outer join fetch sc.contest "
				+ "left outer join fetch sc.student "
				+ "where sc.student=?";
		Query query = getSession().createQuery(hql).setParameter(0, student);
		return query.list();
	}

	

	@Override
	public List<StudentContest> getAllSContest(Contest contest) {
		String hql = "from StudentContest sc "
				+ "left outer join fetch sc.student "
				+ "left outer join fetch sc.contest "
				+ "where sc.contest=?";
		Query query = getSession().createQuery(hql).setParameter(0, contest);
		return query.list();
	}

	@Override
	public boolean updateStuContest(StudentContest studentContest) {
		try {
			studentContest.setIsDisplay(1);
			getSession().update(studentContest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
