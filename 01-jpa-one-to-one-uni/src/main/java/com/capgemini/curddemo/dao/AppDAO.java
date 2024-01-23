package com.capgemini.curddemo.dao;

import com.capgemini.curddemo.entity.Instructor;

public interface AppDAO {
	void save(Instructor theInstructor);
	Instructor findInstructorById(int theId);
	void deleteInstructorById(int theId);
}
