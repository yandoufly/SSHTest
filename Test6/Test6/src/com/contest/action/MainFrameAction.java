package com.contest.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.contest.entities.Contest;
import com.contest.entities.FileContest;
import com.contest.entities.Message;
import com.contest.service.OtherService;
import com.contest.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("MainFrameAction")
public class MainFrameAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private static String filepath = "";
	
	@Resource
	private OtherService otherService;
	
	private Map<String, Object> request;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getAllDatas(){
		List<Contest> allContest = otherService.getAllContest();
		List<Message> allMessage = otherService.getAllMessage();
		request.put("allContest", allContest);
		request.put("allMessage", allMessage);
		return "mainFrame";
	}
	
	public String knowContest(){
		Contest contest = otherService.getContestById(id);
		List<FileContest> listFileContest = otherService.getAllFileBycontestId(id);
		request.put("contest", contest);
		
		//�����ļ���Ϣ
		if(listFileContest!=null && listFileContest.size() != 0){
			filepath = listFileContest.get(0).getFilepath(); 
			// Ŀ¼����
			String[] fileNames = new String[listFileContest.size()];
			for(int i = 0; i < listFileContest.size(); i++){
				fileNames[i] = listFileContest.get(i).getFilename();
				System.out.println(fileNames[i]);
			}
			// ����
			request.put("fileNames", fileNames);
		}

		return "knowContest";
	}
	
	public String knowMessage(){
		Message message = otherService.getMessageById(id);
		request.put("message", message);
		return "knowMessage";
	}
	
	//��ȡ���ྺ����Ϣ
	public String kownmoreContest(){
		List<Contest> allContest = otherService.getAllContest();
		request.put("allContest", allContest);
		return "kownmoreContest";
	}
	
	//�鿴�������Ź���
	public String kownmoreMessage(){
		List<Message> allMessage = otherService.getAllMessage();
		request.put("allMessage", allMessage);
		return "kownmoreMessage";
	}

	//�õ����ྺ����Ϣ
	private String currentPage;
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	//�õ����� �ķ�ҳ����
	public String getmoreContest(){
		try {
			//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
			String currPage = currentPage;
			// �ж�
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
			}
			// ת��
			int currentPage = Integer.parseInt(currPage);
			
			//2. ����PageBean�������õ�ǰҳ������ ����service��������
			PageBean<Contest> pageBean = new PageBean<Contest>();
			pageBean.setCurrentPage(currentPage);
			
			//3. ����service  
			otherService.getAllContest(pageBean); // ��pageBean�Ѿ���dao��������ݡ�
			
			//4. ����pageBean���󣬵�request����
			request.put("pageBean", pageBean);
			
			//5. ��ת 
			return "getPageContest";
		} catch (Exception e) {
			// ���ִ�����ת������ҳ�棻���û��Ѻ���ʾ
		}
		request.put("msg", "����ʧ��");
		return "mainFrame";
	}
	
	public String getmoreMessage(){
		try {
			//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
			String currPage = currentPage;
			// �ж�
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
			}
			// ת��
			int currentPage = Integer.parseInt(currPage);
			
			//2. ����PageBean�������õ�ǰҳ������ ����service��������
			PageBean<Message> pageBean = new PageBean<Message>();
			pageBean.setCurrentPage(currentPage);
			
			//3. ����service  
			otherService.getAllMessage(pageBean); // ��pageBean�Ѿ���dao��������ݡ�
			
			//4. ����pageBean���󣬵�request����
			request.put("pageBean", pageBean);
			
			//5. ��ת 
			return "getPageMessage";
		} catch (Exception e) {
			// ���ִ�����ת������ҳ�棻���û��Ѻ���ʾ
		}
		request.put("msg", "����ʧ��");
		return "mainFrame";
	}
	
	// 1. ��ȡҪ���ص��ļ����ļ���
	private String fileName;
	public void setFileName(String fileName) {
		// �Ѵ���õ��ļ�������ֵ
		this.fileName = fileName;
//		System.out.println("fileName:" + fileName + ",this.fileName:" + this.fileName);
	}
	
	//2. �����ύ��ҵ�񷽷� (��struts.xml�����÷���stream)
	public String down() throws Exception {
		return "download";
	}
	
	// 3. �����ļ����ķ���
	public InputStream getAttrInputStream() throws FileNotFoundException{
		File f = new File(fileName);
		System.out.println("File:" + f);
		InputStream in = new FileInputStream(filepath + "\\" + f); 
		System.out.println("in:" + in);
		return in;
	}
	
	// 4. ������ʾ���ļ������������ʾ���ļ�����
	public String getDownFileName() {
		// ��Ҫ�������ı���
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return fileName;
	}
	
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
	
}
