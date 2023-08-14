package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //
public class DemoController {


    private Coach myCoach;
    private Coach anotherCoach;

    //Create constructor for injections
   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach theAnotherCoach){  //Specify the bean by using the same name as the class but start with lowercase
       System.out.println("In constructor: " + getClass().getSimpleName());
       myCoach = theCoach;
       anotherCoach = theAnotherCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
       return "Comparing beans: mycoach == anotherCoach, "+(myCoach==anotherCoach);
    }
}
