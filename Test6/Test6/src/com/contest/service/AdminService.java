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
	 * �����¼
	 */
	Admin login(int id, String passwd);

	/**
	 * �õ�ȫ��δ�����ѧ���˺�
	 */
	List<Student> getAllNoStatusStudent();

	/**
	 * ����ѧ��
	 */
	boolean activeStudent(int id);

	/**
	 * ͨ��studentId ɾ����ѧ��
	 */
	boolean delStudent(int id);
	
	/**
	 * �õ�ȫ��δ����Ľ�ʦ�˺�
	 */
	List<Teacher> getAllNoStatusTeacher();
	
	/**
	 * �����ʦ
	 */
	boolean activeTeacher(int id);

	/**
	 * ͨ��studentId ɾ���ý�ʦ
	 */
	boolean delTeacher(int id);
	
	/**
	 * �õ�ȫ����ʦ������δ����ľ���
	 */
	List<Contest> getAllTContest();
	
	/**
	 * �����ʦ������δ��������Ź���
	 */
	boolean activeContest(int id);
	
	/**
	 * ɾ������������Ϣ������ �ļ���Ϣ
	 */
	boolean delContest(int id);

	/**
	 * �õ�ȫ����ʦ������δ��������Ź���
	 */
	List<Message> getAllTMessage();

	/**
	 * �����ʦ������δ��������Ź���
	 */
	boolean activeMessage(int id);

	/**
	 * ͨ������id ɾ�������Ź���
	 */
	boolean delMessage(int id);
	
	/**
	 * �������ѧ��
	 */
	boolean insertListStudent(List<Student> list);

	/**
	 * ���������ʦ
	 */
	boolean insertListTeacher(List<Teacher> list);
	
	/**
	 * ����ѧ������
	 */
	boolean resetStuPasswd(int id);

	/**
	 * ���øý�ʦ����
	 */
	boolean resetTeaPasswd(int id);
	
	/**
	 * ע��ѧ���˺�
	 */
	boolean cancelStudent(int studentId);

	/**
	 * ע����ʦ�˺�
	 */
	boolean cancelTeacher(int teacherId);

	/**
	 * �õ�ȫ������
	 */
	List<Contest> getAllContest();

	/**
	 * ����contestId���õ��þ���ȫ������Ϣ
	 */
	List<StudentContest> getStuContestByconstestId(int contestId);

	/**
	 * �޸�ѧ������Ϣ
	 */
	boolean updaStuContest(List<StudentContest> list);

	/**
	 * �鿴ͨ����ʦteacherId��ѯ���ý�ʦ��Ϣ
	 */
	Teacher lookTeacher(int teacherId);
	
}
