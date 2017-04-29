package com.yjy.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页的参数
 */
public class PageBean<T> {
	private int currentPage = 1; 	//当前页, 默认显示第一页
	private int start; 				//查询的起始行, 相当于 limit ?,? 的第一个问号
	private int pageSize = 10;   	//每页显示的行数, limit ?,? 的第二个问号
	private int totalCount;      	//总记录数
	private int totalPage;       	//总页数 = 总记录数 / 每页显示的行数  (+ 1)
	private List<T> pageData;       //分页查询到的数据
	private List<Integer> pageList; //页数列表， 比如页面显示的页区间，1-10, 11-20
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) { //第一个入口
		if(currentPage <= 0) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}
	public int getStart() {
		return start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setpageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {  //第二个入口
		totalPage = (totalCount+pageSize-1)/pageSize; //1. 计算总页数 
		if(currentPage > totalPage){ //当前页 > 总页数
			currentPage = totalPage;
		}
		start = (currentPage -1 ) * pageSize; //2. 计算查询的起始行
		this.setPageList(); //3. 设置页数列表
		this.totalCount = totalCount;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public List<Integer> getPageList() {
		return pageList;
	}
	public void setPageList() {
		if(pageList == null) {
			pageList = new ArrayList<Integer>();
		}
		int area = (currentPage-1)/10*10; //得到当前页所在区域
		for(int i = 1; i <= 10; i++){
			int num = area+i;
			if(num <= totalPage){
				pageList.add(new Integer(num));
			}
		}
	}
}