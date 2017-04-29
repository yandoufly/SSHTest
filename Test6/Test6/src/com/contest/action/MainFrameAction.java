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
		
		//保存文件信息
		if(listFileContest!=null && listFileContest.size() != 0){
			filepath = listFileContest.get(0).getFilepath(); 
			// 目录对象
			String[] fileNames = new String[listFileContest.size()];
			for(int i = 0; i < listFileContest.size(); i++){
				fileNames[i] = listFileContest.get(i).getFilename();
				System.out.println(fileNames[i]);
			}
			// 保存
			request.put("fileNames", fileNames);
		}

		return "knowContest";
	}
	
	public String knowMessage(){
		Message message = otherService.getMessageById(id);
		request.put("message", message);
		return "knowMessage";
	}
	
	//获取更多竞赛信息
	public String kownmoreContest(){
		List<Contest> allContest = otherService.getAllContest();
		request.put("allContest", allContest);
		return "kownmoreContest";
	}
	
	//查看更多新闻公告
	public String kownmoreMessage(){
		List<Message> allMessage = otherService.getAllMessage();
		request.put("allMessage", allMessage);
		return "kownmoreMessage";
	}

	//得到更多竞赛信息
	private String currentPage;
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	//得到竞赛 的分页数据
	public String getmoreContest(){
		try {
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = currentPage;
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 转换
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<Contest> pageBean = new PageBean<Contest>();
			pageBean.setCurrentPage(currentPage);
			
			//3. 调用service  
			otherService.getAllContest(pageBean); // 【pageBean已经被dao填充了数据】
			
			//4. 保存pageBean对象，到request域中
			request.put("pageBean", pageBean);
			
			//5. 跳转 
			return "getPageContest";
		} catch (Exception e) {
			// 出现错误，跳转到错误页面；给用户友好提示
		}
		request.put("msg", "操作失败");
		return "mainFrame";
	}
	
	public String getmoreMessage(){
		try {
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = currentPage;
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 转换
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<Message> pageBean = new PageBean<Message>();
			pageBean.setCurrentPage(currentPage);
			
			//3. 调用service  
			otherService.getAllMessage(pageBean); // 【pageBean已经被dao填充了数据】
			
			//4. 保存pageBean对象，到request域中
			request.put("pageBean", pageBean);
			
			//5. 跳转 
			return "getPageMessage";
		} catch (Exception e) {
			// 出现错误，跳转到错误页面；给用户友好提示
		}
		request.put("msg", "操作失败");
		return "mainFrame";
	}
	
	// 1. 获取要下载的文件的文件名
	private String fileName;
	public void setFileName(String fileName) {
		// 把处理好的文件名，赋值
		this.fileName = fileName;
//		System.out.println("fileName:" + fileName + ",this.fileName:" + this.fileName);
	}
	
	//2. 下载提交的业务方法 (在struts.xml中配置返回stream)
	public String down() throws Exception {
		return "download";
	}
	
	// 3. 返回文件流的方法
	public InputStream getAttrInputStream() throws FileNotFoundException{
		File f = new File(fileName);
		System.out.println("File:" + f);
		InputStream in = new FileInputStream(filepath + "\\" + f); 
		System.out.println("in:" + in);
		return in;
	}
	
	// 4. 下载显示的文件名（浏览器显示的文件名）
	public String getDownFileName() {
		// 需要进行中文编码
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
