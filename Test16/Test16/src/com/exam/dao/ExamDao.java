package com.exam.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.exam.entities.ExamPaper;

@Repository("ExamDao")
public class ExamDao extends SuperDao {

	//判断某份试卷是否已经生成过
	public boolean isPaperExist(ExamPaper paper) {
		String hql = "from ExamPaper paper where paper.exam.examId=:eid and paper.student.sid=:sid";
		List<ExamPaper> list = getSession().createQuery(hql)
				.setParameter("eid", paper.getExam().getExamId())
				.setParameter("sid", paper.getStudent().getSid())
				.list();
		if(list!=null&&list.size()>0) {
			return true;
		}
		
		return false;
	}

	//获得所有考题的id
	public List<Serializable> getAllQuestionId() {
		String hql = "select qid from Question";
		return getSession().createQuery(hql).list();
	}

	//根据用户拿试卷
	public List<ExamPaper> getPaperByUserId(int id) {
		String hql = "from ExamPaper paper where paper.student.sid=:id";
		return getSession().createQuery(hql).setParameter("id",id).list();	
	}

}
