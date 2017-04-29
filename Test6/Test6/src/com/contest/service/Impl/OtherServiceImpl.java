package com.contest.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.contest.dao.ContestDao;
import com.contest.dao.FileContestDao;
import com.contest.dao.MessageDao;
import com.contest.entities.Contest;
import com.contest.entities.FileContest;
import com.contest.entities.Message;
import com.contest.service.OtherService;
import com.contest.utils.PageBean;

@Service("otherService")
public class OtherServiceImpl implements OtherService {
	
	@Resource
	private ContestDao contestDao;
	@Resource
	private FileContestDao fileContestDao;
	@Resource
	private MessageDao messageDao;
	
	@Override
	public boolean addContest(Contest contest) {
		return contestDao.addContest(contest);
	}

	@Override
	public boolean addFileContest(FileContest fileContest) {
		return fileContestDao.addFileContest(fileContest);
	}

	@Override
	public boolean addMessage(Message message) {
		return messageDao.addMessage(message);
	}

	@Override
	public List<Contest> getAllContest() {
		int isDisplay = 1; //已激活
		return contestDao.getListContest(isDisplay);
	}

	@Override
	public List<Message> getAllMessage() {
		int isDisplay = 1; //已激活
		return messageDao.getListMessage(isDisplay);
	}

	@Override
	public Contest getContestById(int id) {
		return contestDao.getContestById(id);
	}

	@Override
	public List<FileContest> getAllFileBycontestId(int contestId) {
		Contest contest = contestDao.getContestById(contestId);
		return fileContestDao.getListByContestId(contest);
	}

	@Override
	public Message getMessageById(int id) {
		return messageDao.getMessageById(id);
	}

	@Override
	public void getAllContest(PageBean<Contest> pb) {
		try {
			contestDao.getAllContest(pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllMessage(PageBean<Message> pb) {
		try {
			messageDao.getAllMessagePage(pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
