package com.capgemini.curddemo.dao;

import com.capgemini.curddemo.entity.Instructor;
import com.capgemini.curddemo.entity.InstructorDetail;

public interface AppDAO {
	void save(Instructor theInstructor);
	Instructor findInstructorById(int theId);
	void deleteInstructorById(int theId);
	InstructorDetail findInstructorDetailById(int theId);
	void deleteInstructorDetailById(int theId);
}
