package com.yjy.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yjy.model.Exam;
import com.yjy.model.PageBean;
import com.yjy.util.HibernateUtil;
import com.yjy.util.StringUtil;

public class ExamDao {

	public void saveExam(Exam exam)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		session.merge(exam);
		tran.commit();
	}
	
	public List<Exam> getExams(Exam s_exam,PageBean pageBean) throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		StringBuffer hql = new StringBuffer("from Exam exam");
		if (s_exam.getStudent() != null && StringUtil.isNotEmpty(s_exam.getStudent().getId())) {
			hql.append(" and exam.student.id='" + s_exam.getStudent().getId() + "'");
		}
		if (s_exam.getStudent() != null && StringUtil.isNotEmpty(s_exam.getStudent().getName())) {
			hql.append(" and exam.student.name like '%" + s_exam.getStudent().getName() + "%'");
		}
		Query query = session.createQuery(hql.toString().replaceFirst("and", "where"));
		if (pageBean != null) {
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getPageSize());
		}
		@SuppressWarnings("unchecked")
		List<Exam> examList = query.list();
		tran.commit();
		return examList;
	}
	
	public int examCount(Exam s_exam)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer sql=new StringBuffer("select count(*) from t_exam t1,t_student t2 where t1.studentId=t2.id ");
		if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getId())){
			sql.append(" and t2.id='"+s_exam.getStudent().getId()+"'");
		}
		if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getName())){
			sql.append(" and t2.name like '%"+s_exam.getStudent().getName()+"%'");
		}
		Query query=session.createSQLQuery(sql.toString());
		int count=((BigInteger)query.uniqueResult()).intValue();
		session.getTransaction().commit();
		return count;
	}
}
