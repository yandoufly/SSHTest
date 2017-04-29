package com.contest.dao;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;

public interface StudentContestDao {

	/**
	 * 添加学生参加竞赛信息
	 */
	void addStudentContest(StudentContest studentContest);
	
	/**
	 * 查询是否有该记录 
	 */
	StudentContest getSContestBySid_Cid(Student student, Contest contest);

	/**
	 * 得到该学生的全部竞赛信息
	 */
	List<StudentContest> getAllSContest(Student student);

	/**
	 * 得到该竞赛的全部学生 获奖信息
	 */
	List<StudentContest> getAllSContest(Contest contest);

	/**
	 * 更新几等奖
	 */
	boolean updateStuContest(StudentContest studentContest);

	
}
