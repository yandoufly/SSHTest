package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import po.Answer;
import po.Exam;
import po.ExamPaper;
import po.Question;
import po.Student;
import po.StudentQuestionRecord;
import dao.ExamDao;
import dao.QuestionDao;

public class ExamService {

	ExamDao examDao;
	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}



	//发起一个考试
	public Exam addExam(Exam e){
		examDao.addEntity(e);
		return e;
	}
	
	//获得所有考试
	public List<Exam> getAllExam(){
		return examDao.getAllEntity(Exam.class);
	}
	
	//根据id拿考试
	public Exam getExamById(int id){
		return (Exam) examDao.getEntityById(Exam.class, id);
	}
	
	//生成一份试卷
	public ExamPaper createExamPaper(Exam exam,Student student){

		ExamPaper paper = new ExamPaper();
		paper.setExam(exam);
		paper.setStudent(student);
		
		//检查是否已经生成过试卷
		boolean b = examDao.isPaperExist(paper);
		if(b){
//			throw new Exception("你的试卷已经生成了，请到 我的试卷 中查看");
			return null;
		}
		
		//试卷下的考题
		//随即产生XX份考题
		//取出当前所有考题的id
		List<Serializable> idList = examDao.getAllQuestionId();
		
		int maxIndex = idList.size();
		
		Set<Question> set = new HashSet<Question>();
		while(set.size()<exam.getExamQuestionCount()){
			//随机产生一道题(随机产生一个下标，从idList中去取一道题)
			int index = (int)(Math.random()*maxIndex);
			int id = (Integer)idList.get(index);
			Question q = (Question) examDao.getEntityById(Question.class,id);
			set.add(q);
		}
		
		//给这份试卷添加考题
		for(Question q:set){
			StudentQuestionRecord record = new StudentQuestionRecord();
			record.setQuestion(q);
			//构造这道题的答案
			Answer A = new Answer("A");
			Answer B = new Answer("B");
			Answer C = new Answer("C");
			Answer D = new Answer("D");
			List<Answer> answers = new ArrayList<Answer>();
			answers.add(A);
			answers.add(B);
			answers.add(C);
			answers.add(D);
			record.setAnswers(answers);
			
			paper.getRecords().add(record);
		}
		
		examDao.addEntity(paper);
		
		return paper;
	}
	
	/**
	 * 根据用户拿试卷
	 */
	public List<ExamPaper> getPaperByUserId(int id){
		return examDao.getPaperByUserId(id);
	}
	
}
