package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.synth.SynthTextAreaUI;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) { // CommandLineRunner is a spring-boot feature. Excecuted after Spring beans are loaded

		return runner -> { // Custom code executed after beans have been loaded
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.luv2code.com/youtube", "luv 2 code");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		Instructor tempInstructor2 = new Instructor("Juan", "Arrechea", "juan@luv2code.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail2 = new InstructorDetail("http//www.luv2code.com/youtube", "geeking");

		// associate the objects
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);

		System.out.println("Saving the instructor: " + tempInstructor2);
		appDAO.save(tempInstructor2);
		System.out.println("Done");

		// create some courses
		Course tempCourse1  = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2  = new Course("The Pinball Master class");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving the instructor: " + tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theID=6;
		System.out.println("Deleting instructor detail id: " + theID);

		appDAO.deleteInstructorDetailsByID(theID);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor details object
		int theID=2;
		InstructorDetail theInstructorDetail = appDAO.findInstructorDetailsByID(theID);


		// print the instructor detail
		System.out.println("tempInstructorDetail: " + theInstructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor: " + theInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theID=1;
		System.out.println("Deleting instructor id: " + theID);

		appDAO.deleteInstructorByID(theID);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theID=2;
		System.out.println("Finding instructor id: "+theID);

		Instructor tempInstructor = appDAO.findInstructorByID(theID);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructor details only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.luv2code.com/youtube", "luv 2 code");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		Instructor tempInstructor2 = new Instructor("Juan", "Arrechea", "juan@luv2code.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail2 = new InstructorDetail("http//www.luv2code.com/youtube", "geeking");

		// associate the objects
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);
		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving the instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");

		System.out.println("Saving the instructor: " + tempInstructor2);
		appDAO.save(tempInstructor2);
		System.out.println("Done");
	}
}
