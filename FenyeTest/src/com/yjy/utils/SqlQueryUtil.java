package com.yjy.utils;

import java.util.ArrayList;
import java.util.List;

public class SqlQueryUtil {
	
	private String fromClause = ""; //from 子句
	private String whereClause = ""; //where子句
	private String orderClause = ""; //order by子句
	private List<Object> parameters; //对应 ？里的参数
	
	//排序顺序
	public static String ORDER_BY_ASC = "ASC"; //升序
	public static String ORDER_BY_DESC = "DESC"; //降序
	
	/**
	 * 构造from子句
	 * @param clazz 实体类
	 * @param alias 实体类对应别名
	 */
	public SqlQueryUtil(String table, String alias){
		
		fromClause = "FROM " + table + " " + alias;
	}

	/**
	 * 构造where子句
	 * @param condition 查询条件语句;例如：i.title like ?
	 * @param params 查询条件语句中？对应的查询条件;例如：%title%
	 */
	public void addCondition(String condition, Object... params){
		if(whereClause.length() > 1) { //非第一个条件
			whereClause += " AND " + condition;
		}else{ //第一个条件
			whereClause += " WHERE " + condition;
		}
		//设置查询条件对应参数
		if(parameters == null){
			parameters = new ArrayList<Object>();
		}
		if(params != null){
			for(Object ob : params){
				parameters.add(ob);
			}
		}
	}

	/**
	 * 构造order by子句 
	 * @param property 排序属性; 例如：i.createTime
	 * @param order 排序顺序; 例如：DESC 或 ASC
	 */
	public void addOrderProperty(String property, String order){
		if(orderClause.length() > 1){ //非第一个排序属性
			orderClause += ", " + property + " " + order;
		}else{ //第一个排序属性
			orderClause = " ORDER BY " + property + " " + order;
		}
	}
	
	/**
	 * 查询“数据集合”的sql语句
	 */
	public String getSqlQueryList(){
		return "SELECT * " + fromClause + whereClause + orderClause;
	}
	
	/**
	 * 查询“总记录数”的sql语句
	 */
	public String getSqlQueryCount(){
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	//查询sql语句对应条件参数集合
	public List<Object> getParameters() {
		return parameters;
	}
	//测试
	public static void main(String[] args) {
		SqlQueryUtil sqlQueryUtil = new SqlQueryUtil("orders", "o");
		sqlQueryUtil.addCondition("o.title like ?", "标题");
		sqlQueryUtil.addCondition("o.startTime=?", "2016-3-20");
		sqlQueryUtil.addCondition("o.createTime=?", "2016-5-20");
		sqlQueryUtil.addOrderProperty("o.title", ORDER_BY_ASC);
		sqlQueryUtil.addOrderProperty("o.startTime", ORDER_BY_DESC);
		
		String str1 = sqlQueryUtil.getSqlQueryList();
		System.out.println(str1);
		
		String str2 = sqlQueryUtil.getSqlQueryCount();
		System.out.println(str2);
		
		List<Object> list = sqlQueryUtil.getParameters();
		for(Object ob : list){
			System.out.print(ob + " ");
		}
	}
}
