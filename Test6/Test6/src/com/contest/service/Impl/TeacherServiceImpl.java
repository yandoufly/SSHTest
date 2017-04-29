package com.contest.service.Impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.contest.dao.ContestDao;
import com.contest.dao.StudentContestDao;
import com.contest.dao.StudentDao;
import com.contest.dao.TeacherDao;
import com.contest.entities.Contest;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;
import com.contest.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	
	@Resource
	private TeacherDao teacherDao;
	
	@Resource
	private StudentDao studentDao;
	
	@Resource
	private ContestDao contestDao;
	@Resource
	private StudentContestDao studentContestDao;
	
	
	@Override
	public Teacher login(int teacherId, String passwd) {
		Teacher teacher = teacherDao.getTeacherByTid(teacherId);
		if(teacher==null) return null;
		
		if(passwd.equals(teacher.getPasswd())){
			return teacher;
		}
		return null;
	}
	@Override
	public boolean register(Teacher teacher) {
		return teacherDao.insertTeacher(teacher);
		
	}
	@Override
	public List<StudentContest> getAllSContest(int contestId) {
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
				sc.setCreateTime(new Date());
				studentContestDao.updateStuContest(sc);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
