package com.contest.dao;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.entities.FileContest;

public interface FileContestDao {
	
	/**
	 * 为竞赛添加附件信息
	 */
	boolean addFileContest(FileContest fileContest);
	
	/**
	 * 通过contestId 得到该全部附件
	 */
	List<FileContest> getListByContestId(Contest contest);

	/**
	 * 删除该文件信息
	 */
	boolean delFileContest(FileContest f);

}
