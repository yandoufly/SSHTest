package com.contest.service;

import java.util.List;

import com.contest.entities.Admin;
import com.contest.entities.Contest;
import com.contest.entities.Message;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;

public interface AdminService {
	
	/**
	 * 处理登录
	 */
	Admin login(int id, String passwd);

	/**
	 * 得到全部未激活的学生账号
	 */
	List<Student> getAllNoStatusStudent();

	/**
	 * 激活学生
	 */
	boolean activeStudent(int id);

	/**
	 * 通过studentId 删除该学生
	 */
	boolean delStudent(int id);
	
	/**
	 * 得到全部未激活的教师账号
	 */
	List<Teacher> getAllNoStatusTeacher();
	
	/**
	 * 激活教师
	 */
	boolean activeTeacher(int id);

	/**
	 * 通过studentId 删除该教师
	 */
	boolean delTeacher(int id);
	
	/**
	 * 得到全部教师发布的未激活的竞赛
	 */
	List<Contest> getAllTContest();
	
	/**
	 * 激活教师发布的未激活的新闻公告
	 */
	boolean activeContest(int id);
	
	/**
	 * 删除该条竞赛信息，附带 文件信息
	 */
	boolean delContest(int id);

	/**
	 * 得到全部教师发布的未激活的新闻公告
	 */
	List<Message> getAllTMessage();

	/**
	 * 激活教师发布的未激活的新闻公告
	 */
	boolean activeMessage(int id);

	/**
	 * 通过主键id 删除该新闻公告
	 */
	boolean delMessage(int id);
	
	/**
	 * 批量添加学生
	 */
	boolean insertListStudent(List<Student> list);

	/**
	 * 批量添加老师
	 */
	boolean insertListTeacher(List<Teacher> list);
	
	/**
	 * 重置学生密码
	 */
	boolean resetStuPasswd(int id);

	/**
	 * 重置该教师密码
	 */
	boolean resetTeaPasswd(int id);
	
	/**
	 * 注销学生账号
	 */
	boolean cancelStudent(int studentId);

	/**
	 * 注销教师账号
	 */
	boolean cancelTeacher(int teacherId);

	/**
	 * 得到全部竞赛
	 */
	List<Contest> getAllContest();

	/**
	 * 根据contestId，得到该竞赛全部获奖信息
	 */
	List<StudentContest> getStuContestByconstestId(int contestId);

	/**
	 * 修改学生获奖消息
	 */
	boolean updaStuContest(List<StudentContest> list);

	/**
	 * 查看通过教师teacherId查询到该教师信息
	 */
	Teacher lookTeacher(int teacherId);
	
}
