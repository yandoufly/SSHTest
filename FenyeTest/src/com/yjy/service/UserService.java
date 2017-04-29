package com.yjy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yjy.entity.User;
import com.yjy.utils.PageBean;
import com.yjy.utils.SqlQueryUtil;

public class UserService {
	private static Connection ct = null;
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test", "root", "123456");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 版本1：得到分页数据
	 * @param pageBean
	 */
	public void getUserByPage(PageBean<User> pageBean) {
		try {
			//1.查询总记录数,并存放daopageBean对象中
			pageBean.setTotalCount(this.getTotalCount());

			//2. 分页查询数据;  把查询到的数据设置到pb对象中
			String sql = "select * from user limit ?,?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setInt(1, pageBean.getStart());
			ps.setInt(2, pageBean.getPageSize());
			ResultSet rs = ps.executeQuery();
			List<User> pageData = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUpdatetime(rs.getDate("updatetime"));
				pageData.add(user);
			}
			pageBean.setPageData(pageData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到总记录数
	 * @throws SQLException 
	 */
	private int getTotalCount() throws SQLException {
		String sql = "select count(*) from user";
		PreparedStatement ps = ct.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
}
