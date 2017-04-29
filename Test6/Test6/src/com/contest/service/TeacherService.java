package com.contest.service;

import java.util.List;

import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;

public interface TeacherService {
	/**
	 * �����¼��ͨ��teacherId�õ��ý�ʦ����
	 */
	Teacher login(int teacherId, String passwd);
	/**
	 * ����ע��
	 */
	boolean register(Teacher teacher);
	
	/**
	 * ͨ������������id �õ�ȫ���μӾ�����ѧ����Ϣ
	 */
	List<StudentContest> getAllSContest(int contestId);

	/**
	 * ����ѧ���μӾ�����Ļ���Ϣ
	 */
	boolean updaStuContest(List<StudentContest> list);

}
