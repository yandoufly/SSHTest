package com.contest.dao;

import java.util.List;

import com.contest.entities.Message;
import com.contest.utils.PageBean;

public interface MessageDao {

	/**
	 * 插入一条新闻
	 */
	boolean addMessage(Message message);

	/**
	 * 得到全部教师发布的未激活的新闻公告
	 */
	List<Message> getListMessage(int isDisplay);

	/**
	 * 通过主键 id获取该新闻公告
	 */
	Message getMessageById(int id);

	/**
	 * 通过主键id 删除该新闻公告
	 */
	boolean delMessage(int id);
	
	/**
	 * 分页的Message
	 */
	void getAllMessagePage(PageBean<Message> pb);
	
	/**
	 * 得到总记录数
	 * @return
	 */
	int getTotalCount();
	
}
