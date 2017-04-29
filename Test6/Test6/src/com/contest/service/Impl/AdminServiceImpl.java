package com.contest.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.contest.dao.AdminDao;
import com.contest.dao.ContestDao;
import com.contest.dao.FileContestDao;
import com.contest.dao.MessageDao;
import com.contest.dao.StudentContestDao;
import com.contest.dao.StudentDao;
import com.contest.dao.TeacherDao;
import com.contest.entities.Admin;
import com.contest.entities.Contest;
import com.contest.entities.FileContest;
import com.contest.entities.Message;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;
import com.contest.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminDao adminDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private ContestDao contestDao;
	@Resource
	private FileContestDao fileContestDao;
	@Resource
	private MessageDao messageDao;
	@Resource
	private StudentContestDao studentContestDao;
	
	
	@Override
	public Admin login(int id, String passwd) {
		Admin admin = adminDao.getAdminById(id);
		if(admin == null) return null;
		
		if(passwd.equals(admin.getPasswd())){
			return admin;
		}
		return null;
	}

	@Override
	public List<Student> getAllNoStatusStudent() {
		int status = 0;
		return studentDao.getListStudent(status);
	}

	@Override
	public boolean activeStudent(int id) {
		Student student = studentDao.getStudentBySid(id);
		try {
			student.setStatus(1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delStudent(int id) {
		return studentDao.delStudent(id);
	}

	@Override
	public List<Teacher> getAllNoStatusTeacher() {
		int status = 0;
		return teacherDao.getListTeacher(status);
	}

	@Override
	public boolean activeTeacher(int id) {
		Teacher teacher = teacherDao.getTeacherByTid(id);
		try {
			teacher.setStatus(1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delTeacher(int id) {
		return teacherDao.delTeacher(id);
	}

	@Override
	public List<Contest> getAllTContest() {
		int isDisplay = 0; //δ��ʾ״̬
		return contestDao.getListContest(isDisplay);
	}

	@Override
	public boolean activeContest(int id) {
		try {
			Contest contest = contestDao.getContestById(id);
			contest.setIsDisplay(1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delContest(int id) {
		try {
			Contest contest = contestDao.getContestById(id);
			List<FileContest> list = fileContestDao.getListByContestId(contest);
			for(FileContest f : list){
				fileContestDao.delFileContest(f);
			}
			contestDao.delContest(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Message> getAllTMessage() {
		int isDisplay = 0; //δ��ʾ״̬
		return messageDao.getListMessage(isDisplay);
	}

	@Override
	public boolean activeMessage(int id) {
		try {
			Message message = messageDao.getMessageById(id);
			message.setIsDisplay(1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delMessage(int id) {
		return messageDao.delMessage(id);
	}

	@Override
	public boolean insertListStudent(List<Student> list) {
		for(Student student : list){
			student.setStatus(1);
			boolean b = studentDao.insertStudent(student);
			if(!b){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean insertListTeacher(List<Teacher> list) {
		for(Teacher teacher: list){
			teacher.setStatus(1);
			boolean b = teacherDao.insertTeacher(teacher);
			if(!b){
				return false;
			}
		}
		return true;
		
	}

	@Override
	public boolean resetStuPasswd(int id) {
		try {
			Student student = studentDao.getStudentBySid(id);
			student.setPasswd("123456");
			studentDao.updateStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean resetTeaPasswd(int id) {
		try {
			Teacher teacher = teacherDao.getTeacherByTid(id);
			teacher.setPasswd("123456");
			teacherDao.updateTeacher(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cancelStudent(int studentId) {
		try {
			Student student = studentDao.getStudentBySid(studentId);
			student.setStatus(0);
			studentDao.updateStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cancelTeacher(int teacherId) {
		try {
			Teacher teacher = teacherDao.getTeacherByTid(teacherId);
			teacher.setStatus(0);
			teacherDao.updateTeacher(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Contest> getAllContest() {
		int isDisplay = 1;
		return contestDao.getListContest(isDisplay);
	}

	@Override
	public List<StudentContest> getStuContestByconstestId(int contestId) {
		Contest contest = contestDao.getContestById(contestId);
		List<StudentContest> allSContest = studentContestDao.getAllSContest(contest);
		return allSContest;
	}

	@Override
	public boolean updaStuContest(List<StudentContest> list) {
		try {
			for(int i = 0; i < list.size(); i++){
				StudentContest sc = list.get(i);
				Student student = studentDao.getStudentBySid(sc.getStudent().getStudentId());
				sc.setStudent(student);
				studentContestDao.updateStuContest(sc);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Teacher lookTeacher(int teacherId) {
		return teacherDao.getTeacherByTid(teacherId);
		
	}

	
	
}
