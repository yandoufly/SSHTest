package com.contest.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contest.dao.MessageDao;
import com.contest.entities.Contest;
import com.contest.entities.Message;
import com.contest.utils.PageBean;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDao implements MessageDao {

	@Override
	public boolean addMessage(Message message) {
		try {
			getSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Message> getListMessage(int isDisplay) {
		String hql = "from Message m where m.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, isDisplay);
		return query.list();
	}

	@Override
	public Message getMessageById(int id) {
		return (Message) getSession().get(Message.class, id);
	}

	@Override
	public boolean delMessage(int id) {
		try {
			Message message = (Message) getSession().get(Message.class, id);
			getSession().delete(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void getAllMessagePage(PageBean<Message> pb) {

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
		String hql = "from Message s where s.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, 1);
		List<Message> pageData = query.setFirstResult(index)
									.setMaxResults(count)
									.list();  
		
		// 设置到pb对象中
		pb.setPageData(pageData);
	}

	@Override
	public int getTotalCount() {
		String hql = "select count(*) from Message c where c.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, 1);
		int i = Integer.parseInt((query.iterate().next()).toString());
		return i;
	}
	
}
