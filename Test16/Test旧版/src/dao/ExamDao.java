package dao;

import java.io.Serializable;
import java.util.List;

import po.ExamPaper;

public class ExamDao extends SuperDao{
	
	//判断某份试卷是否已经生成过
	public boolean isPaperExist(ExamPaper paper){

		List<ExamPaper> list = sessionFactory.getCurrentSession()
		.createQuery("from ExamPaper paper where paper.exam.examId=:eid and paper.student.sid=:sid")
		.setParameter("eid", paper.getExam().getExamId())
		.setParameter("sid", paper.getStudent().getSid())
		.list();
		
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	//根据用户拿试卷
	public List<ExamPaper> getPaperByUserId(int id){
		return sessionFactory.getCurrentSession().createQuery("from ExamPaper paper where paper.student.sid=:id").setParameter("id",id).list();
	}
	
	//获得所有考题的id
	public List<Serializable> getAllQuestionId(){
		return sessionFactory.getCurrentSession().createQuery("select qid from Question").list();
	}
}
