package com.contest.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.FileContestDao;
import com.contest.entities.Contest;
import com.contest.entities.FileContest;

@Repository("fileContestDao")
public class FileContestDaoImpl extends BaseDao implements FileContestDao {

	@Override
	public boolean addFileContest(FileContest fileContest) {
		try {
			getSession().save(fileContest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<FileContest> getListByContestId(Contest contest) {
		String hql = "from FileContest f where f.contest=?";
		Query query = getSession().createQuery(hql).setParameter(0, contest);
		return  query.list();
	}

	@Override
	public boolean delFileContest(FileContest f) {
		try {
			getSession().delete(f);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
