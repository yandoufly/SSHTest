package service;

import java.util.List;
import java.util.Set;

import po.Module;
import po.Role;
import po.Student;
import dao.StudentDao;

public class StudentService {

	//保存一个学生
	public Student addStudent(Student s){
		//获得角色
		studentDao.addEntity(s);
		return s;
	}
	
	
	//登录
	public Student login(String number,String pwd){
		Student s = studentDao.getStudentByNumber(number);
		if(s!=null&&s.getSpwd().equals(pwd)){
			return s;
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * 显示所有用户
	 * @return
	 */
	public List<Student> showAllStudent(){
		
		
		return studentDao.getAllEntity(Student.class);
		
	}
	
	/**
	 * 
	 * 根据用户ID拿用户
	 * @param sid
	 * @return
	 */
	public Student getStudentById(int sid){
		
		
		return (Student) studentDao.getEntityById(Student.class, sid);
	}
	
	
	/**
	 * 
	 * 为用户添加角色
	 * @param role
	 * @param modules
	 * @return
	 */
	public Student updateRole(Student student,Set<Role> roles){
		
		student = (Student) studentDao.getEntityById(Student.class, student.getSid());
		student.getRoles().clear();
		student.setRoles(roles);
		
		return student;
	}
		
	/**
	 * 获取所有角色
	 * 
	 * @return
	 */
	public List<Role> getAllRoles(){
		
		return studentDao.getAllEntity(Role.class);
	}
	
	
	
	StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	
}
