package com.luv2code.springboot.cruddemo.REST;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty: inject employee DAO
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findByID(employeeID);

        if (theEmployee == null){
            throw new RuntimeException("Employee id not found: "+employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees") // change mapping type from GET to POST
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // Also just in case pass in id in JSON set id to 0
        // this is to force a save of new item instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees") // update existing employee
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee =employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findByID(employeeID);

        if (theEmployee == null) {
             throw  new RuntimeException("Employee id not found - "+ employeeID);
        }

        employeeService.deleteByID(employeeID);

        return "Deleted employee ID = "+employeeID;
    }

}
