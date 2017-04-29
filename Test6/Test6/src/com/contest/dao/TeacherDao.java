package com.contest.dao;

import java.util.List;

import com.contest.entities.Teacher;

public interface TeacherDao {
	
	/**
	 * �õ�һ����ʦ����
	 */
	Teacher getTeacherByTid(int teacherId);
	
	/**
	 * ���һ����ʦ
	 */
	boolean insertTeacher(Teacher teacher);
	
	/**
	 * ͨ��status �õ�ȫ������/δ�����ʦ��Ϣ
	 */
	List<Teacher> getListTeacher(int status);

	/**
	 * ͨ������id ɾ���ý�ʦ
	 */
	boolean delTeacher(int id);

	/**
	 * ���¸ý�ʦ
	 */
	void updateTeacher(Teacher teacher);

}
