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
	
	// 上传多个文件的集合文本 
	private List<File> upload; 
	// /多个上传文件的类型集合  
	private List<String> uploadContextType; 
	// 多个上传文件的文件名集合
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

			/***** 获取上传路径 *****/
			String path = "D:\\upload\\" + contest.getTitle();
			File file = new File(path);  
	        if (!file.exists()) {  
	            file.mkdirs();  
	        }  
	        // 把得到的文件的集合通过循环的方式读取并放在指定的路径下 
	        if(upload != null){
	        	for (int i = 0; i < upload.size(); i++) {  
		            try {  
		                //list集合通过get(i)的方式来获取索引  
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
				request.put("msg", "发布竞赛成功！！");
				return "adminMainFrame";
			}else{
				request.put("msg", "发布成功，请等待管理员审核！！");
				return "teacherMainFrame";
			}
		}
		request.put("msg", "发布不成功");
		return "addContest";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
}
