package com.contest.dao;

import java.util.List;

import com.contest.entities.Contest;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;

public interface StudentContestDao {

	/**
	 * ���ѧ���μӾ�����Ϣ
	 */
	void addStudentContest(StudentContest studentContest);
	
	/**
	 * ��ѯ�Ƿ��иü�¼ 
	 */
	StudentContest getSContestBySid_Cid(Student student, Contest contest);

	/**
	 * �õ���ѧ����ȫ��������Ϣ
	 */
	List<StudentContest> getAllSContest(Student student);

	/**
	 * �õ��þ�����ȫ��ѧ�� ����Ϣ
	 */
	List<StudentContest> getAllSContest(Contest contest);

	/**
	 * ���¼��Ƚ�
	 */
	boolean updateStuContest(StudentContest studentContest);

	
}
