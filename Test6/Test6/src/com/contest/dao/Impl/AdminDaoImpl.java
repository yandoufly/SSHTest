package com.contest.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.AdminDao;
import com.contest.entities.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public Admin getAdminById(int id) {
		String hql = "from Admin m where m.id=?";
		Query query = getSession().createQuery(hql).setParameter(0, id);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}
	
}
