package com.contest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.contest.entities.Contest;
import com.contest.entities.Student;
import com.contest.entities.StudentContest;
import com.contest.entities.Teacher;

public class MyExcel {
	public static  List readXlsx(String path, int entity) throws IOException {
		InputStream is = new FileInputStream(path);
		System.out.println(is);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		List list = new ArrayList<>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					if(entity == 1){
						Student student = new Student();
						xssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						 
						String studentId = xssfRow.getCell(0).getStringCellValue();
						String name = xssfRow.getCell(1).getStringCellValue();
						String passwd = xssfRow.getCell(2).getStringCellValue();
						String sex = xssfRow.getCell(3).getStringCellValue();
						String dept = xssfRow.getCell(4).getStringCellValue();
						String profess = xssfRow.getCell(5).getStringCellValue();
						
						student.setStudentId(Integer.parseInt(studentId));
						student.setName(name);
						student.setPasswd(passwd);
						student.setSex(sex);
						student.setDept(dept);
						student.setProfess(profess);
						list.add(student);
					}else if(entity == 2){
						//老师
						Teacher teacher = new Teacher();
						
						xssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						 
						String teacherId = xssfRow.getCell(0).getStringCellValue();
						String passwd = xssfRow.getCell(1).getStringCellValue();
						String name = xssfRow.getCell(2).getStringCellValue();
						String sex = xssfRow.getCell(3).getStringCellValue();
						String profess = xssfRow.getCell(4).getStringCellValue();
						
						teacher.setTeacherId(Integer.parseInt(teacherId));
						teacher.setPasswd(passwd);
						teacher.setName(name);
						teacher.setSex(sex);
						teacher.setProfess(profess);
						
						list.add(teacher);
					}else if(entity == 3){
						//学生参加竞赛消息
						StudentContest studentContest = new StudentContest();
						
						
						xssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						xssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						 
						String id = xssfRow.getCell(0).getStringCellValue();
						String contestId = xssfRow.getCell(1).getStringCellValue();
						String studentId = xssfRow.getCell(3).getStringCellValue();
						String rank = xssfRow.getCell(5).getStringCellValue();
						
						studentContest.setId(Integer.parseInt(id));
						
						Contest contest = new Contest();
						contest.setId(Integer.parseInt(contestId));
						studentContest.setContest(contest);
						
						Student student = new Student();
						student.setStudentId(Integer.parseInt(studentId));
						studentContest.setStudent(student);
						
						studentContest.setRank(rank);
						
						list.add(studentContest);
					}
				}
			}
		}
		return list;
	}

}
