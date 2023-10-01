package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructor(appDAO);
		};
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

//		// create the instructor
//		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//		// create instructor detail
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.luv2code.com/youtube", "luv 2 code");
//
//		// associate the objects
//		tempInstructor.setInstructorDetail(tempInstructorDetail);


		Instructor tempInstructor = new Instructor("Juan", "Arrechea", "juan@luv2code.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.luv2code.com/youtube", "geeking");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving the instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}
}
