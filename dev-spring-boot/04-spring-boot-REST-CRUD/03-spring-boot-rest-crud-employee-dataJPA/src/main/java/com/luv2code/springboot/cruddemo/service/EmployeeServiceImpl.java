package com.luv2code.springboot.cruddemo.service;


import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByID(int theID) {
        Employee theEmployee = null;

        Optional<Employee> result = employeeRepository.findById(theID);

        if (result.isPresent()){
            theEmployee = result.get();
        } else{
            throw new RuntimeException("Did not find employee id of: "+theID);
        }
        return theEmployee;
    }

    @Override // No need for @Transactional becasue of JPA repository
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteByID(int theID) {
        employeeRepository.deleteById(theID);
    }
}
