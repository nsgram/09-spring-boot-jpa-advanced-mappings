package com.capgemini.curddemo.dao;

import java.util.List;

import com.capgemini.curddemo.entity.Course;
import com.capgemini.curddemo.entity.Instructor;
import com.capgemini.curddemo.entity.InstructorDetail;
import com.capgemini.curddemo.entity.Student;

public interface AppDAO {
	void save(Instructor theInstructor);
	Instructor findInstructorById(int theId);
	void deleteInstructorById(int theId);
	InstructorDetail findInstructorDetailById(int theId);
	void deleteInstructorDetailById(int theId);
	List<Course> findCoursesByInstructorId(int theId);
	Instructor findInstructorByIdJoinFetch(int theId);
	void updateInstructor(Instructor instructor);
	void updateCourse(Course course);
	Course findCourseById(int theId);
	void deleteCourseById(int theId);
	
	void saveCourse(Course theCourse);
	Course findCourseAndReviewsByCourseId(int theId);
	Course findCourseAndStuedentByCourseId(int theId);
	
	Student findStudentAndCourseByStudentId(int theId);
	void updateStudent(Student student);
	void deleteStudentById(int theId);
	
}
