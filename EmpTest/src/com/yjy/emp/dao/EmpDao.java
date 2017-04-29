package com.yjy.emp.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import com.yjy.emp.entity.Emp;
import com.yjy.emp.util.JdbcUtil;

@Repository("empDao")
public class EmpDao {
	/**
	 * 查询所有员工
	 */
	public List<Emp> findAll() throws Exception{
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "SELECT empno,username,salary,hiredate FROM emp";
		return queryRunner.query(sql,new BeanListHandler<Emp>(Emp.class));
	}
	
	public static void main(String[] args) throws Exception {
		EmpDao dao = new EmpDao();
		for(Emp emp : dao.findAll()){
			System.out.println(emp.toString());
		}
	}
}