package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  //Marks the class as a SpringBean, making available for dependency injection
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void startUp(){
        System.out.println("In startup(): "+ getClass().getSimpleName());
    }
    // define destroy method
    @PreDestroy
    public void cleanup(){
        System.out.println("In cleanup(): "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }


}
