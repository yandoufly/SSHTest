package com.contest.dao;

import java.util.List;

import com.contest.entities.Message;
import com.contest.utils.PageBean;

public interface MessageDao {

	/**
	 * ����һ������
	 */
	boolean addMessage(Message message);

	/**
	 * �õ�ȫ����ʦ������δ��������Ź���
	 */
	List<Message> getListMessage(int isDisplay);

	/**
	 * ͨ������ id��ȡ�����Ź���
	 */
	Message getMessageById(int id);

	/**
	 * ͨ������id ɾ�������Ź���
	 */
	boolean delMessage(int id);
	
	/**
	 * ��ҳ��Message
	 */
	void getAllMessagePage(PageBean<Message> pb);
	
	/**
	 * �õ��ܼ�¼��
	 * @return
	 */
	int getTotalCount();
	
}
