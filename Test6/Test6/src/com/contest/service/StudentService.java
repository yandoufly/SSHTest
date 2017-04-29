package com.contest.service;

import java.util.List;

import com.contest.entities.Student;
import com.contest.entities.StudentContest;

public interface StudentService {

	/**
	 * 处理登录
	 */
	Student login(int id, String passwd);

	/**
	 * 处理注册
	 */
	boolean register(Student student);

	/**
	 * 参加竞赛
	 */
	boolean entryContest(int studentId, int contestId);

	/**
	 * 获取所有该学生参加过的竞赛
	 */
	List<StudentContest> getAllSContest(int studentId);

	/**
	 * 查看一个学生信息
	 */
	Student getStudent(int studentId);

	/**
	 * 修改个人信息
	 */
	void updateStudent(Student student);
	
}
