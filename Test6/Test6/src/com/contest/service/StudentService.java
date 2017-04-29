package com.contest.service;

import java.util.List;

import com.contest.entities.Student;
import com.contest.entities.StudentContest;

public interface StudentService {

	/**
	 * �����¼
	 */
	Student login(int id, String passwd);

	/**
	 * ����ע��
	 */
	boolean register(Student student);

	/**
	 * �μӾ���
	 */
	boolean entryContest(int studentId, int contestId);

	/**
	 * ��ȡ���и�ѧ���μӹ��ľ���
	 */
	List<StudentContest> getAllSContest(int studentId);

	/**
	 * �鿴һ��ѧ����Ϣ
	 */
	Student getStudent(int studentId);

	/**
	 * �޸ĸ�����Ϣ
	 */
	void updateStudent(Student student);
	
}
