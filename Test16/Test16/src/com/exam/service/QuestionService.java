package com.exam.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.QuestionDao;
import com.exam.entities.Question;
import com.exam.utils.PageBean;

@Service("QuestionService")
public class QuestionService {
	
	@Resource
	private QuestionDao questionDao;
	
	//添加问题
	public Question addQuestion(Question question) {
		System.out.println("QuestionService addQuestion..");
		questionDao.addEntity(question);
		return question;
	}

	//得到分页的问题集合
	public void getPageQuestion(PageBean<Question> pageBean) {
		questionDao.getPageQuestion(pageBean);
	}

	//删除题目
	public boolean deleteQuestionById(int qid) {
		try {
			questionDao.deleteEntityById(Question.class, qid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Question getQuestionById(int qid) {
		return (Question) questionDao.getEntityById(Question.class, qid);
	}

	public void updateQuestion(Question question) {
		questionDao.updateEntity(question);
	}

}
