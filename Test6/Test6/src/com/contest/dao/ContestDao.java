package com.contest.dao;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.utils.PageBean;

public interface ContestDao {
	/**
	 * ����һ��������Ϣ
	 */
	boolean addContest(Contest contest);
	
	/**
	 * ͨ�� isDisplay �õ�һ������
	 */
	List<Contest> getListContest(int isDisplay);

	/**
	 * ͨ�� ����id �õ�contest����
	 */
	Contest getContestById(int id);

	/**
	 * ͨ������id ɾ���þ�����Ϣ
	 */
	boolean delContest(int id);
	
	/**
	 * ��ҳ��ѯ����
	 */
	void getAllContest(PageBean<Contest> pb);
	
	/**
	 * �õ���¼����
	 */
	int getTotalCount();
}
