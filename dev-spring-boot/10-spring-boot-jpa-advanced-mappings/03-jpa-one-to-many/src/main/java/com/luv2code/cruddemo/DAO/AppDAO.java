package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorByID(int theID);

    void deleteInstructorByID(int theID);

    InstructorDetail findInstructorDetailsByID(int theID);

    void deleteInstructorDetailsByID(int theID);

}
