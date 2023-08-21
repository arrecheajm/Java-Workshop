package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

    private List<Student> theStudents;

    // define construct to load hte student data.. only loads the bean once

    @PostConstruct
    public void LoadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Juan", "Arrechea"));
        theStudents.add(new Student("Pedro", "Juarez"));
        theStudents.add(new Student("Mike", "McKalister"));
    }

    // define an endpoint for /students - return a list of all of the students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint fr "/sudents/{student}Id" - return student at index

    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        // just index into the list... keep it simple for now
        // check the studentID against list size
        if(studentID >= theStudents.size() || (studentID < 0)){
            throw new StudentNotFoundException("Student ID not found - "+studentID);
        } else {
            return theStudents.get(studentID);
        }
    }
}
