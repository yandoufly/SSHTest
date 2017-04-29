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

		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);

		// �ж�
		if (pb.getCurrentPage() <= 0) {
			pb.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// ��ѯ����ʼ��
		int count = pb.getPageCount();							// ��ѯ���ص�����
		
		
		//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
		
		// ���ݵ�ǰҳ����ѯ��ǰҳ����(һҳ����)
		String hql = "from Contest c where c.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, 1);
		List<Contest> pageData = query.setFirstResult(index).setMaxResults(count).list();  
		
		// ���õ�pb������
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
