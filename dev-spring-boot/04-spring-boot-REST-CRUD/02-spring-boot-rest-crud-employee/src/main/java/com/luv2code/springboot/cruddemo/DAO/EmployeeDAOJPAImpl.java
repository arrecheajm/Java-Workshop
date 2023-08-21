package com.luv2code.springboot.cruddemo.DAO;


import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EmployeeDAOJPAImpl implements EmployeeDAO {

    //Define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager theEntityManger){
        entityManager = theEntityManger;
    }


    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return results
        return employees;
    }

    @Override
    public Employee findByID(int theID) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theID);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteByID(int theID) {
        // find employee
        Employee theEmployee = entityManager.find(Employee.class, theID);

        // delete employee
        entityManager.remove(theEmployee); 
    }
}
