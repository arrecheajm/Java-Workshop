package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //REST Support
@RequestMapping("/test")  //Adding mapping
public class DemoRESTController {

    // add conde for the "hello world" endpoint
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!!";
    }

}
