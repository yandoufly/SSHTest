package service;

import java.util.Date;
import java.util.List;

import po.Answer;
import po.ExamPaper;
import po.Option;
import po.StudentQuestionRecord;
import dao.PaperDao;

public class PaperService {
	
	//根据id拿试卷
	public ExamPaper getPaperById(int id){
		return (ExamPaper) paperDao.getEntityById(ExamPaper.class, id);
	}
	
	
	//更新一份试卷
	public ExamPaper updatePaper(ExamPaper paper){
		paperDao.updateEntity(paper);
		return paper;
	}
	
	//计算一份试卷的得分
	public float countScore(ExamPaper paper){
		//总分
		int total = paper.getExam().getExamTotalScore();
		//题量
		int count = paper.getRecords().size();
		
		//每题多少分呢
		float p = (float)total/count;
		
		//最终得分
		float result = 0;
		
		for(int i=0;i<count;i++){
			StudentQuestionRecord record = paper.getRecords().get(i);
			//答案
			List<Answer> list = record.getAnswers();
			//标准答案
			List<Option> olist = record.getQuestion().getOptions();
			
			if(list.get(0).getYes()==olist.get(0).getYes()&&
			   list.get(1).getYes()==olist.get(1).getYes()&&
			   list.get(2).getYes()==olist.get(2).getYes()&&
			   list.get(3).getYes()==olist.get(3).getYes()){
				
				result+=p;
				
			}
		}
		
		
		return result;
	}
	
	/**
	 * 准备试卷
	 * @param id
	 * @param isNew true:开始考试   false:继续考试
	 * @return
	 */
	public ExamPaper createPaper(int id,boolean isNew){
		//获得试卷
		ExamPaper paper = this.getPaperById(id);
		//设置试卷的状态
		paper.setState("考试中");
		if(isNew){
			paper.setStartTime(new Date().toLocaleString());
		}
//		updatePaper(paper);
		return paper;
	}
	
	/**
	 * 把答案记录在试卷上
	 */
	//记录试卷
	public ExamPaper recordPaper(int paperId,int index,List<Answer> answers){
		//取出试卷
		ExamPaper paper = this.getPaperById(paperId);
		//给试卷上的这道题添加学生所选的答案
		paper.getRecords().get(index).setAnswers(answers);

		return paper;
	}
	
	/**
	 * 提交试卷
	 */
	public ExamPaper commitPaper(int paperId,int index,List<Answer> answers){
		//记录答案
		ExamPaper paper = recordPaper(paperId, index, answers);
		//修改试卷状态
		paper.setState("已完成");
		paper.setCommitTime(new Date().toLocaleString());
		
		//计算得分
		float score = this.countScore(paper);
		paper.setScore(score);
		
		return paper;
	}
	
	/**
	 * 根据试卷ID获得该试卷的考试时间
	 */
	public int getExamTimeByPaperId(int id){
		return this.getPaperById(id).getExam().getExamTime();
	}
	
	PaperDao paperDao;

	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}
	
}
