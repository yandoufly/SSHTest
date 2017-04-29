package com.contest.dao;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.utils.PageBean;

public interface ContestDao {
	/**
	 * 插入一条竞赛信息
	 */
	boolean addContest(Contest contest);
	
	/**
	 * 通过 isDisplay 得到一个集合
	 */
	List<Contest> getListContest(int isDisplay);

	/**
	 * 通过 主键id 得到contest对象
	 */
	Contest getContestById(int id);

	/**
	 * 通过主键id 删除该竞赛信息
	 */
	boolean delContest(int id);
	
	/**
	 * 分页查询数据
	 */
	void getAllContest(PageBean<Contest> pb);
	
	/**
	 * 得到记录总数
	 */
	int getTotalCount();
}
