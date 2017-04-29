package com.contest.service;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.entities.FileContest;
import com.contest.entities.Message;
import com.contest.utils.PageBean;

public interface OtherService {
	/**
	 * ����һ��������Ϣ
	 */
	boolean addContest(Contest contest);
	
	/**
	 * Ϊ������Ӹ���
	 */
	boolean addFileContest(FileContest fileContest);
	
	/**
	 * ����һ������
	 */
	boolean addMessage(Message message);
	
	/**
	 * �õ������Ѽ���ľ�����Ϣ
	 */
	List<Contest> getAllContest();

	/**
	 * �õ������Ѽ�������Ź���
	 */
	List<Message> getAllMessage();

	/**
	 * �鿴����
	 */
	Contest getContestById(int id);

	/**
	 * ͨ��contest�е�������ȡȫ��FIleContest��Ϣ
	 */
	List<FileContest> getAllFileBycontestId(int contestId);

	/**
	 * �鿴���Ź���
	 */
	Message getMessageById(int id);
	
	/**
	 * �õ� ���� �ķ�ҳ����
	 */
	void getAllContest(PageBean<Contest> pb);

	/**
	 * �õ� ���Ź��� �ķ�ҳ����
	 */
	void getAllMessage(PageBean<Message> pb);
	
	
}
