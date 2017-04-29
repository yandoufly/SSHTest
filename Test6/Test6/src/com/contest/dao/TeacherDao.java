package com.contest.dao;

import java.util.List;

import com.contest.entities.Teacher;

public interface TeacherDao {
	
	/**
	 * 得到一个教师对象
	 */
	Teacher getTeacherByTid(int teacherId);
	
	/**
	 * 添加一个教师
	 */
	boolean insertTeacher(Teacher teacher);
	
	/**
	 * 通过status 得到全部激活/未激活教师信息
	 */
	List<Teacher> getListTeacher(int status);

	/**
	 * 通过主键id 删除该教师
	 */
	boolean delTeacher(int id);

	/**
	 * 更新该教师
	 */
	void updateTeacher(Teacher teacher);

}
