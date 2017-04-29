package com.contest.dao;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.entities.FileContest;

public interface FileContestDao {
	
	/**
	 * Ϊ������Ӹ�����Ϣ
	 */
	boolean addFileContest(FileContest fileContest);
	
	/**
	 * ͨ��contestId �õ���ȫ������
	 */
	List<FileContest> getListByContestId(Contest contest);

	/**
	 * ɾ�����ļ���Ϣ
	 */
	boolean delFileContest(FileContest f);

}
