package service;

import java.util.List;

import po.Question;
import dao.QuestionDao;

public class QuestionService {

	QuestionDao questionDao;

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	//添加一道题目
	public Question addQuestion(Question q){
		questionDao.addEntity(q);
		return q;
	}
	
	//根据id拿题目
	public Question getQuestionById(int id){
		return (Question) questionDao.getEntityById(Question.class, id);
	}
	
	//删除一道题目
	public boolean deleteQuestionById(int id){
		try{
		questionDao.deleteEntityById(Question.class, id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	//修改一道题
	public void updateQuestion(Question q){
		questionDao.updateEntity(q);
	}
	
	//获得所有考题
	public List<Question> getAllQuestion(int begin,int pageSize){
		return questionDao.getAllEntity(Question.class, begin, pageSize);
	}
	
	//获得所有考题的总数
	public long getQuestionCount(){
		return questionDao.getEntityCount(Question.class);
	}
}
