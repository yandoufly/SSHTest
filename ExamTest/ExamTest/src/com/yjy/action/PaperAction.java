package com.yjy.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yjy.dao.PaperDao;
import com.yjy.dao.QuestionDao;
import com.yjy.model.Paper;
import com.yjy.model.Question;
import com.yjy.util.ResponseUtil;
import com.yjy.util.StringUtil;

import net.sf.json.JSONObject;

public class PaperAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private PaperDao paperDao = new PaperDao();
	private QuestionDao questionDao = new QuestionDao();
	
	private String mainPage;
	private List<Paper> paperList=new ArrayList<Paper>();
	
	private String paperId;
	private Paper paper;
	
	private List<Question> squestionList=new ArrayList<Question>();
	private List<Question> mquestionList=new ArrayList<Question>();
	
	private String title;

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public List<Question> getSquestionList() {
		return squestionList;
	}

	public void setSquestionList(List<Question> squestionList) {
		this.squestionList = squestionList;
	}

	public List<Question> getMquestionList() {
		return mquestionList;
	}

	public void setMquestionList(List<Question> mquestionList) {
		this.mquestionList = mquestionList;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public List<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Paper> paperList) {
		this.paperList = paperList;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String list()throws Exception{
		paperList=paperDao.getPapers();
		mainPage="exam/selectPaper.jsp";
		return SUCCESS;
	}
	
	public String paperList()throws Exception{
		paperList=paperDao.getPapers();
		mainPage="paper/paperList.jsp";
		return SUCCESS;
	}
	
	public String deletePaper()throws Exception{
		paper=paperDao.getPaper(paperId);
		JSONObject resultJson=new JSONObject();
		if(questionDao.existQuestionByPaperId(paperId)){
			resultJson.put("error", "�Ծ���������Ŀ������ɾ��");
		}else{
			paperDao.paperDelete(paper);
			resultJson.put("success", true);
		}
		ResponseUtil.write(resultJson, ServletActionContext.getResponse());
		return null;
	}
	
	public String getDetailPaper() throws Exception{
		paper = paperDao.getPaper(paperId);
		Set<Question> questionList = paper.getQuestions();
		Iterator<Question> it = questionList.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			if ("1".equals(q.getType())) { 
				squestionList.add(q); //单选题
			} else {
				mquestionList.add(q); //多选题
			}
		}
		squestionList = this.getRandowQuestion(squestionList, 3);
		mquestionList = this.getRandowQuestion(mquestionList, 2);
		mainPage = "exam/paper.jsp";
		return SUCCESS;
	}

	//随机获取题目
	private List<Question> getRandowQuestion(List<Question> questionList,int num){
		List<Question> resultList=new ArrayList<Question>();
		Random random=new Random();
		if(num>0){
			for(int i=1;i<=num;i++){
				int n=random.nextInt(questionList.size());
				Question q=questionList.get(n);
				if(resultList.contains(q)){
					i--;
				}else{
					resultList.add(q);
				}
			}
		}
		return resultList;
	}
	
	public String preSave()throws Exception{
		if(StringUtil.isNotEmpty(paperId)){
			paper=paperDao.getPaper(paperId);
			title="�޸��Ծ�";
		}else{
			title="����Ծ�";
		}
		mainPage="paper/paperSave.jsp";
		return SUCCESS;
	}
	
	public String savePaper()throws Exception{
		if(StringUtil.isNotEmpty(paperId)){
			paper.setId(Integer.parseInt(paperId));
		}else{
			paper.setJoinDate(new Date());
		}
		paperDao.savePaper(paper);
		return "save";
	}
}
