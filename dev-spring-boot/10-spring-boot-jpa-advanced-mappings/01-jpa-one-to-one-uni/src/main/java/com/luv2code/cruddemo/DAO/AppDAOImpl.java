package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // Tell Spring can find it during component scanning
public class AppDAOImpl implements AppDAO{

    // define a field for entity manager
    private EntityManager entityManager;

    // inject the entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor); // will save the details because of the save cascade
    }

    @Override
    public Instructor findInstructorByID(int theID) {
        return entityManager.find(Instructor.class, theID); //Eager find will return all associated data
    }

    @Override
    @Transactional // Because methods changes database
    public void deleteInstructorByID(int theID) {
        // retrieve the instructor
        Instructor templateInstructor = entityManager.find(Instructor.class, theID);

        // delete the instructor
        entityManager.remove(templateInstructor);
    }
}
