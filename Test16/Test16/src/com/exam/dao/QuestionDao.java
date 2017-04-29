package com.exam.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.exam.entities.Question;
import com.exam.utils.PageBean;

@Repository("QuestionDao")
public class QuestionDao extends SuperDao{

	//得到分页信息
	public void getPageQuestion(PageBean<Question> pb) {
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
		String hql = "from Question q";
		Query query = getSession().createQuery(hql);
		List<Question> pageData = query.setFirstResult(index).setMaxResults(count).list();  
		System.out.println("Question's size" + pageData.size());
		
		// 设置到pb对象中
		pb.setPageData(pageData);
	}
	
	public int getTotalCount() {
		String hql = "select count(*) from Question q";
		Query query = getSession().createQuery(hql);
		int i = Integer.parseInt((query.iterate().next()).toString());
		return i;
	}

}
