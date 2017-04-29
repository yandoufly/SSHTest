package com.contest.dao;

import java.util.List;

import com.contest.entities.Student;

public interface StudentDao {

	/**
	 * 得到一个学生对象
	 */
	Student getStudentBySid(int studentId);

	/**
	 * 添加一个学生
	 */
	boolean insertStudent(Student student);
	
	/**
	 * 通过status状态 得到一个学生集合
	 */
	List<Student> getListStudent(int status);

	/**
	 * 删除通过主键id 该学生
	 */
	boolean delStudent(int id);

	/**
	 * 修改个人信息
	 */
	void updateStudent(Student student);

}
