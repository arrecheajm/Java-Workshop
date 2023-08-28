package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }


    // Any kind of validation can be performed in this method, even if it needs a database or REST api services, it can be done here
    @Override
    public boolean isValid(String theCode,
                           ConstraintValidatorContext constraintValidatorContext) { // Extra parameter that can be used to give extra error information
        boolean result = false;

        if (theCode != null){
            result = theCode.startsWith(coursePrefix);
        }
        return result;
    }
}
