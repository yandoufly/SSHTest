package com.contest.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.ContestDao;
import com.contest.entities.Contest;
import com.contest.utils.PageBean;

@Repository("contestDao")
public class ContestDaoImpl extends BaseDao implements ContestDao {

	public boolean addContest(Contest contest) {
		try {
			getSession().save(contest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Contest> getListContest(int isDisplay) {
		String hql = "from Contest c where c.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, isDisplay);
		return query.list();
	}

	@Override
	public Contest getContestById(int id) {
		return (Contest) getSession().get(Contest.class, id);
	}

	@Override
	public boolean delContest(int id) {
		try {
			Contest contest = (Contest) getSession().get(Contest.class, id);
			getSession().delete(contest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void getAllContest(PageBean<Contest> pb) {

		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);

		// 判断
		if (pb.getCurrentPage() <= 0) {
			pb.setCurrentPage(1);					    // 把当前页设置为1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
		}
		
		//1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行
		int count = pb.getPageCount();							// 查询返回的行数
		
		
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
		
		// 根据当前页，查询当前页数据(一页数据)
		String hql = "from Contest c where c.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, 1);
		List<Contest> pageData = query.setFirstResult(index).setMaxResults(count).list();  
		
		// 设置到pb对象中
		pb.setPageData(pageData);
	}

	@Override
	public int getTotalCount() {
		String hql = "select count(*) from Contest c where c.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, 1);
		int i = Integer.parseInt((query.iterate().next()).toString());
		return i;
	}

}
