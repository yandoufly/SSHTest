package com.exam.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.ExamDao;
import com.exam.entities.Answer;
import com.exam.entities.Exam;
import com.exam.entities.ExamPaper;
import com.exam.entities.Question;
import com.exam.entities.Student;
import com.exam.entities.StudentQuestionRecord;

@Service("ExamService")
public class ExamService {

	@Resource
	private ExamDao examDao;
	
	//添加考试
	public void addExam(Exam exam) {
		examDao.addEntity(exam);
	}

	//获得所有考试
	public List<Exam> getAllExam() {
		return examDao.getAllEntity(Exam.class);
	}

	//根据id拿考试
	public Exam getExamById(int id) {
		return (Exam) examDao.getEntityById(Exam.class, id);
	}

	//生成一份试卷
	public ExamPaper createExamPaper(Exam exam,Student student) {

		ExamPaper paper = new ExamPaper();
		paper.setExam(exam);
		paper.setStudent(student);
		
		//检查是否已经生成过试卷
		boolean b = examDao.isPaperExist(paper);
		if(b){
			System.out.println("你的试卷已经生成了，请到 我的试卷 中查看");
			return null;
		}
		System.out.println("isPaperExist is ok!!");
		//试卷下的考题
		//随即产生XX份考题
		//取出当前所有考题的id
		List<Serializable> idList = examDao.getAllQuestionId();
		
		int maxIndex = idList.size();
		
		System.out.println("aaaaaaaaaaa");
		System.out.println("maxIndex:" + maxIndex);
		Set<Question> set = new HashSet<Question>();
		while(set.size() < exam.getExamQuestionCount()){
			//随机产生一道题(随机产生一个下标，从idList中去取一道题)
			int index = (int)(Math.random()*maxIndex);
			int id = (Integer)idList.get(index);
			System.out.println("index:"+index + ", id:"+id);
			Question q = (Question) examDao.getEntityById(Question.class,id);
			set.add(q);
		}
		System.out.println("aaaaaaaaaaa");
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
		
		System.out.println("aszsasssasasas");
		examDao.addEntity(paper);
		System.out.println("aszsasssasasas");
		
		return paper;
	}

	//根据用户拿试卷
	public List<ExamPaper> getPaperByUserId(int id) {
		return examDao.getPaperByUserId(id);
	}

}
