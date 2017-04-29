package com.contest.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.contest.entities.Contest;
import com.contest.entities.FileContest;
import com.contest.service.OtherService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ContestAction")
public class ContestAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	@Resource
	private OtherService otherService;
	
	private Map<String, Object> request;

	private String title; 
	private String grade; 
	private String organiser; 
	private Date startTime; 
	private Date endRegTime; 
	private String content;
	private int isDisplay;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getOrganiser() {
		return organiser;
	}
	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndRegTime() {
		return endRegTime;
	}
	public void setEndRegTime(Date endRegTime) {
		this.endRegTime = endRegTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	} 
	
	// �ϴ�����ļ��ļ����ı� 
	private List<File> upload; 
	// /����ϴ��ļ������ͼ���  
	private List<String> uploadContextType; 
	// ����ϴ��ļ����ļ�������
	private List<String> uploadFileName;  

	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	
	public List<String> getUploadContextType() {
		return uploadContextType;
	}
	public void setUploadContextType(List<String> uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String addContest() throws Exception {
		System.out.println("isDisplay:" + isDisplay);
		Contest contest = new Contest(title, grade, organiser, startTime, endRegTime, content, isDisplay);
		boolean b = otherService.addContest(contest);
		
		if(b){

			/***** ��ȡ�ϴ�·�� *****/
			String path = "D:\\upload\\" + contest.getTitle();
			File file = new File(path);  
	        if (!file.exists()) {  
	            file.mkdirs();  
	        }  
	        // �ѵõ����ļ��ļ���ͨ��ѭ���ķ�ʽ��ȡ������ָ����·���� 
	        if(upload != null){
	        	for (int i = 0; i < upload.size(); i++) {  
		            try {  
		                //list����ͨ��get(i)�ķ�ʽ����ȡ����  
		                FileUtils.copyFile(upload.get(i), new File(file, uploadFileName.get(i)));  
		                String filename = uploadFileName.get(i);
						String filepath = path;
						FileContest fileContest = new FileContest(contest, filename, filepath);
						otherService.addFileContest(fileContest);
		            } catch (IOException e) {  
		                e.printStackTrace();  
		            }  
		        } 
	        }
	        
			
			if(isDisplay == 1){
				request.put("msg", "���������ɹ�����");
				return "adminMainFrame";
			}else{
				request.put("msg", "�����ɹ�����ȴ�����Ա��ˣ���");
				return "teacherMainFrame";
			}
		}
		request.put("msg", "�������ɹ�");
		return "addContest";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
}
