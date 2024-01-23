package com.capgemini.curddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.curddemo.entity.Instructor;
import com.capgemini.curddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
@Repository
public class AppDAOImpl implements AppDAO {
	private EntityManager manager;
	@Autowired
	public AppDAOImpl(EntityManager manager) {
		this.manager =manager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		manager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {
		return manager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		Instructor tempInstructor = manager.find(Instructor.class, theId);
		manager.remove(tempInstructor);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		 return manager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		// load instructor detail by id
		InstructorDetail theDetail = manager.find(InstructorDetail.class, theId);
		//remove the associated object reference
		//break bi-direction link
		theDetail.getInstructor().setInstructorDetail(null);
		manager.remove(theDetail);
		
	}

}
