package com.capgemini.curddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.curddemo.dao.AppDAO;
import com.capgemini.curddemo.entity.Course;
import com.capgemini.curddemo.entity.Instructor;
import com.capgemini.curddemo.entity.InstructorDetail;
import com.capgemini.curddemo.entity.Review;
import com.capgemini.curddemo.entity.Student;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao)
	{
		return runner -> {
			//createCoureseAndStudents(dao);
			//findCourseAndStudents(dao);
			//findStudentAndCourses(dao);
			//addMoreCoursesForStudent(dao);
			//deleteCourese(dao);
			deleteStudent(dao);
			
		};
	}

	private void deleteStudent(AppDAO dao) {
		int theId = 12;
		dao.deleteStudentById(theId);
		System.out.println("Done");
		
	}

	private void addMoreCoursesForStudent(AppDAO dao) {
		int theId = 11;
		Student tmpStudent = dao.findStudentAndCourseByStudentId(theId);
		
		//add more couse for student
		Course tempCourse1 = new Course("C Tech");
		Course tempCourse2 = new Course("C++ Tech");
		Course tempCourse3 = new Course("python Tech");
		tmpStudent.addCourse(tempCourse1);
		tmpStudent.addCourse(tempCourse2);
		tmpStudent.addCourse(tempCourse3);
		
		System.out.println("Saving student object :"+tmpStudent);
		System.out.println("Associated courses :"+tmpStudent.getCourses());
		
		dao.updateStudent(tmpStudent);
		System.out.println("Done");
		
	}

	private void findStudentAndCourses(AppDAO dao) {
		int theId =11;
		Student student = dao.findStudentAndCourseByStudentId(theId);
		System.out.println("Student : "+student);
		System.out.println("Courses : "+student.getCourses());
		System.out.println("Done");
		
	}

	private void findCourseAndStudents(AppDAO dao) {
		int theId =5;
		Course course  = dao.findCourseAndStuedentByCourseId(theId);
		System.out.println("Course -"+course);
		System.out.println("Student -"+course.getStudents());
		System.out.println("Done");
		
	}

	private void createCoureseAndStudents(AppDAO dao) {
		Course tempCourse1 = new Course("Java Tech");
		Course tempCourse2 = new Course("C Tech");
		Course tempCourse3 = new Course("C++ Tech");
		Course tempCourse4 = new Course("python Tech");
		Course tempCourse5 = new Course("javaScript Tech");
		
		
		Student tmpStudent1 = new Student("Join", "Deo", "deo@cg.com");
		Student tmpStudent2 = new Student("Mary", "clerk", "clerk@cg.com");
		
		tempCourse1.addStudent(tmpStudent1);
		tempCourse1.addStudent(tmpStudent2);
		
//		tmpStudent1.addCourse(tempCourse1);
//		tmpStudent1.addCourse(tempCourse3);
//		tmpStudent1.addCourse(tempCourse5);
//		
//		tmpStudent2.addCourse(tempCourse1);
//		tmpStudent2.addCourse(tempCourse2);
//		tmpStudent2.addCourse(tempCourse4);
		
		System.out.println("Saving the course :"+tempCourse1);
		System.out.println("Saving the student :"+tempCourse1.getStudents());
		dao.saveCourse(tempCourse1);
		System.out.println("Done");
		
		
	}

	private void deleteCourseAndReviews(AppDAO dao) {
		int theId = 4;
		dao.deleteCourseById(theId);
		System.out.println("Done");
		
		
	}

	private void retriveCourseAndReviews(AppDAO dao) {
		int theId = 4;
		Course tempCourse = dao.findCourseAndReviewsByCourseId(theId);
		System.out.println("Course :"+tempCourse);
		System.out.println("Reviews :"+tempCourse.getReviews());
		System.out.println("Done");
	}

	private void createCourseAndReviws(AppDAO dao) {
		Course course = new Course("DataBase");
		Review tempReview1 = new Review("Good");
		Review tempReview2 = new Review("Best");
		Review tempReview3 = new Review("fair");
		
		course.add(tempReview1);
		course.add(tempReview2);
		course.add(tempReview3);
		dao.saveCourse(course);
		System.out.println("Done");
	}

	private void deleteCourese(AppDAO dao) {
		int theid = 6;
		dao.deleteCourseById(theid);
		System.out.println("Done");
		
	}

	private void updateCourse(AppDAO dao) {
		int theId =3;
		Course course = dao.findCourseById(theId);
		course.setTitle("Test_Course");
		dao.updateCourse(course);
		System.out.println("Course :"+course);
		System.out.println("Done");
	}

	private void updateInstructor(AppDAO dao) {
		int theId= 2;
		Instructor tempInstructor = dao.findInstructorByIdJoinFetch(theId);
		System.out.println("old Instructor :"+tempInstructor);
		tempInstructor.setLastName("test");
		dao.updateInstructor(tempInstructor);
		System.out.println("updated Instructor :"+tempInstructor);
		System.out.println("Done");
		
	}

	private void findInstructorByIdJoinFetch(AppDAO dao) {
		int theId= 2;
		Instructor tempInstructor = dao.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor :"+tempInstructor);
		System.out.println("_____________________________________");
		System.out.println("Courses :"+tempInstructor.getCourses());
		System.out.println("Done");
		
	}

	private void findCourseForInstructor(AppDAO dao) {
		int theId= 2;
		Instructor tempInstructor = dao.findInstructorById(theId);
		
		//finding courses for instructor 
		List<Course> courses = dao.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("Instructor :"+tempInstructor);
		System.out.println("____________________________________");
		System.out.println("Courses :"+tempInstructor.getCourses());
		
		//System.out.println("Courses :"+courses);
		System.out.println("Done");
		
	}

	private void findInstructorWithCourses(AppDAO dao) {
		int theId= 2;
		Instructor tempInstructor = dao.findInstructorById(theId);
		System.out.println("Instructor :"+tempInstructor);
		System.out.println("Courses :"+tempInstructor.getCourses());
		System.out.println("Done");
		
	}

	private void createInstructorWithCourses(AppDAO dao) {
		Instructor tempInstructor = new Instructor("Susan","Das","das@cg.com");
		InstructorDetail detail = new InstructorDetail("http://www.das.com", "Video game");
		//associated object
		tempInstructor.setInstructorDetail(detail);
		//create some course 
		Course tempCourse1 = new Course("JAVA");
		Course tempCourse2 = new Course("C");
		Course tempCourse3 = new Course("python");
		
		//cources to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);
		
		//save instructor
		System.out.println("Saving Instructor -> "+tempInstructor);
		dao.save(tempInstructor);
		System.out.println("Saved");
		
	}

	private void deleteInstructorDetail(AppDAO dao) {
		int theId=4;
		dao.deleteInstructorDetailById(theId);
		System.out.println("Done");
		
	}

	private void findInstructorDetail(AppDAO dao) {
		int theId =1;
		InstructorDetail tempInstructorDetail = dao.findInstructorDetailById(theId);
		System.out.println("InstructorDetail :"+tempInstructorDetail);
		System.out.println("____________________");
		System.out.println("Instructor :"+tempInstructorDetail.getInstructor());
		
	}

	private void deleteInstructor(AppDAO dao) {
		dao.deleteInstructorById(2);
		System.out.println("Instructor deletes");
		
	}

	private void findInstructor(AppDAO dao) {
		int theId= 2;
		Instructor theInstructor = dao.findInstructorById(theId);
		System.out.println("Read Instructor :"+theInstructor);
		System.out.println("Read InstructorDetails :"+theInstructor.getInstructorDetail());
		
	}

	private void createInstructor(AppDAO dao) {
		// create Instructor
		Instructor tempInstructor = new Instructor("Carry","Christon","christon@cg.com");
		InstructorDetail detail = new InstructorDetail("http://www.cgchristom.com", "christon world");
		
		tempInstructor.setInstructorDetail(detail);
		
		System.out.println("saving the instructor ->"+tempInstructor);
		dao.save(tempInstructor);
		System.out.println("Done...!!!");
	}
}
