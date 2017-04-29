package com.contest.service;

import java.util.List;

import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;

public interface TeacherService {
	/**
	 * 处理登录，通过teacherId得到该教师对象
	 */
	Teacher login(int teacherId, String passwd);
	/**
	 * 处理注册
	 */
	boolean register(Teacher teacher);
	
	/**
	 * 通过竞赛的主键id 得到全部参加竞赛的学生信息
	 */
	List<StudentContest> getAllSContest(int contestId);

	/**
	 * 更新学生参加竞赛后的获奖信息
	 */
	boolean updaStuContest(List<StudentContest> list);

}
