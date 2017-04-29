package com.contest.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.contest.entities.Contest;
import com.contest.entities.Message;
import com.contest.service.OtherService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("MessageAction")
public class MessageAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private OtherService otherService;
	
	private Message message;
	
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	private Map<String, Object> request; 
	
	public String addMessage(){
		message.setCreateTime(new Date());
		System.out.println("message��Ϣ��" + message);
		boolean b = otherService.addMessage(message);
		if(b){
			if(message.getIsDisplay() == 1){
				request.put("msg", "�������Ź���ɹ�����");
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
