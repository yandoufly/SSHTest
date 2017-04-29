package com.exam.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.exam.dao.StudentDao;
import com.exam.entities.Role;
import com.exam.entities.Student;

@Service("StudentService")
public class StudentService {
	
	@Resource
	private StudentDao studentDao;

	//登录
	public Student login(String snumber, String spwd) {
		Student s = studentDao.getStudentByNumber(snumber);
		if(s!=null&&s.getSpwd().equals(spwd)){
			return s;
		}else{
			return null;
		}
	}

	//批量导入学生
	public void importStuExcel(File userExcel, String userExcelFileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(userExcel);
			boolean is03Excel = userExcelFileName.matches("^.+\\.(?i)(xls)$");
			//1、读取工作簿
			Workbook workbook = is03Excel ? new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);
			//2、读取工作表
			Sheet sheet = workbook.getSheetAt(0);
			
			//3、读取行
			if(sheet.getPhysicalNumberOfRows() > 1){
				Student student = null;
				for(int k = 1; k < sheet.getPhysicalNumberOfRows(); k++){
					//4、读取单元格
					Row row = sheet.getRow(k);
					student = new Student();
					
					//用户名
					Cell cell0 = row.getCell(0);
					if(cell0 != null){
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						student.setSname(cell0.getStringCellValue());
					}
					//帐号
					Cell cell1 = row.getCell(1);
					if(cell1 != null){
						cell1.setCellType(Cell.CELL_TYPE_STRING);
						student.setSnumber(cell1.getStringCellValue());
					}
					//密码
					Cell cell2 = row.getCell(2);
					if(cell2 != null){
						cell2.setCellType(Cell.CELL_TYPE_STRING);
						student.setSpwd(cell2.getStringCellValue());
					}
					
					//5、保存用户
					studentDao.addEntity(student);
				}
			}
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//显示全部用户
	public List<Student> showAllStudent() {
		return studentDao.getAllEntity(Student.class);
	}

	//根据学号sid得到用户
	public Student getStudentBySid(int sid) {
		return (Student) studentDao.getEntityById(Student.class, sid);
	}

	//获取所有角色
	public List<Role> getAllRoles() {
		return studentDao.getAllEntity(Role.class);
	}

	//为用户更新角色
	public void updateRole(Student student, Set<Role> roleSet) {
		student = (Student) studentDao.getEntityById(Student.class, student.getSid());
		student.getRoles().clear();
		student.setRoles(roleSet);
	}

}
