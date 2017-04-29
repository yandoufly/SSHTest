package com.contest.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.contest.dao.ContestDao;
import com.contest.dao.StudentContestDao;
import com.contest.dao.StudentDao;
import com.contest.entities.Contest;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentDao studentDao;
	@Resource
	private ContestDao contestDao;
	@Resource
	private StudentContestDao studentContestDao;
	@Override
	public Student login(int id, String passwd) {
		Student student = studentDao.getStudentBySid(id);
		if(student==null) return null;
		
		if(passwd.equals(student.getPasswd())){
			return student;
		}
		return null;
	}
	@Override
	public boolean register(Student student) {
		boolean b = studentDao.insertStudent(student);
		return b;
	}
	@Override
	public boolean entryContest(int studentId, int contestId) {
		//ͨ��studentId ��ȡ��ѧ��
		Student student = studentDao.getStudentBySid(studentId);
		//��ȡ����
		Contest contest = contestDao.getContestById(contestId);
		
		System.out.println(student.getId() + " " + contest.getId());
		//��ѯ���ݿ��Ƿ��и�����¼
		StudentContest sc = studentContestDao.getSContestBySid_Cid(student, contest);
		if(sc == null){
			StudentContest studentContest = new StudentContest();
			studentContest.setStudent(student);
			studentContest.setContest(contest);
			studentContest.setCreateTime(new Date());
			
			studentContest.setIsDisplay(0);
			studentContest.setRank("�޻���Ϣ");
			studentContestDao.addStudentContest(studentContest);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<StudentContest> getAllSContest(int studentId) {
		Student student = studentDao.getStudentBySid(studentId);
		List<StudentContest> list = studentContestDao.getAllSContest(student);
		return list;
	}
	@Override
	public Student getStudent(int studentId) {
		return studentDao.getStudentBySid(studentId);
	}
	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

}
