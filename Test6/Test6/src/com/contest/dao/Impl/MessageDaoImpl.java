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
		String hql = "from Message s where s.isDisplay=?";
		Query query = getSession().createQuery(hql).setParameter(0, 1);
		List<Message> pageData = query.setFirstResult(index)
									.setMaxResults(count)
									.list();  
		
		// ���õ�pb������
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
