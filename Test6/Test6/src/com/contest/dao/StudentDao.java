package com.contest.dao;

import java.util.List;

import com.contest.entities.Student;

public interface StudentDao {

	/**
	 * �õ�һ��ѧ������
	 */
	Student getStudentBySid(int studentId);

	/**
	 * ���һ��ѧ��
	 */
	boolean insertStudent(Student student);
	
	/**
	 * ͨ��status״̬ �õ�һ��ѧ������
	 */
	List<Student> getListStudent(int status);

	/**
	 * ɾ��ͨ������id ��ѧ��
	 */
	boolean delStudent(int id);

	/**
	 * �޸ĸ�����Ϣ
	 */
	void updateStudent(Student student);

}
