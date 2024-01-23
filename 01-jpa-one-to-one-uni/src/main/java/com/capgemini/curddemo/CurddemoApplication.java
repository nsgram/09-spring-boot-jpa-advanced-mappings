package com.capgemini.curddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.curddemo.dao.AppDAO;
import com.capgemini.curddemo.entity.Instructor;
import com.capgemini.curddemo.entity.InstructorDetail;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao)
	{
		return runner -> {
			//createInstructor(dao);
			//findInstructor(dao);
			deleteInstructor(dao);
			};
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
