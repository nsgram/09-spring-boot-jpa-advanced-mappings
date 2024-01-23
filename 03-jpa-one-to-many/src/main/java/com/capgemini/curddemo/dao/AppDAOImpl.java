package com.capgemini.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.curddemo.entity.Course;
import com.capgemini.curddemo.entity.Instructor;
import com.capgemini.curddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		Instructor instructor =manager.find(Instructor.class, theId);
		//get the course
		List<Course> courses = instructor.getCourses();
		//Break the association
		for (Course course : courses) {
			course.setInstructor(null);
		}
		
		manager.remove(instructor);	
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

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		TypedQuery<Course> query = manager.createQuery("from Course where instructor.id = :data", Course.class);
		query.setParameter("data", theId);
		return query.getResultList();
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		TypedQuery<Instructor> query = manager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data", Instructor.class);
		query.setParameter("data", theId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor instructor) {
		manager.merge(instructor);
	}

	@Override
	@Transactional
	public void updateCourse(Course course) {
		manager.merge(course);
	}

	@Override
	public Course findCourseById(int theId) {
		 return manager.find(Course.class, theId);
	}
	
	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		Course tempCourse = manager.find(Course.class, theId);
		manager.remove(tempCourse);
	}
}