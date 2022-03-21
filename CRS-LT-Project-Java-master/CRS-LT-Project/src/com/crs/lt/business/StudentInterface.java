package com.crs.lt.business;

import java.util.Set;

import com.crs.lt.bean.GradeCard;
import com.crs.lt.bean.Student;

public interface StudentInterface {

	public void register(Student student);

	public Student getStudentById(int studentId);

	public void deleteStudent(int studentId);

	public Student updateStudent(Student student);

	public Set<Student> listStudent();

	public GradeCard viewGradeCard(int studentId);
}
