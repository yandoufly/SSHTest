package com.contest.service;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.entities.FileContest;
import com.contest.entities.Message;
import com.contest.utils.PageBean;

public interface OtherService {
	/**
	 * 插入一条竞赛信息
	 */
	boolean addContest(Contest contest);
	
	/**
	 * 为竞赛添加附件
	 */
	boolean addFileContest(FileContest fileContest);
	
	/**
	 * 插入一条新闻
	 */
	boolean addMessage(Message message);
	
	/**
	 * 得到所有已激活的竞赛信息
	 */
	List<Contest> getAllContest();

	/**
	 * 得到所有已激活的新闻公告
	 */
	List<Message> getAllMessage();

	/**
	 * 查看竞赛
	 */
	Contest getContestById(int id);

	/**
	 * 通过contest中的主键获取全部FIleContest信息
	 */
	List<FileContest> getAllFileBycontestId(int contestId);

	/**
	 * 查看新闻公告
	 */
	Message getMessageById(int id);
	
	/**
	 * 得到 竞赛 的分页数据
	 */
	void getAllContest(PageBean<Contest> pb);

	/**
	 * 得到 新闻公告 的分页数据
	 */
	void getAllMessage(PageBean<Message> pb);
	
	
}
