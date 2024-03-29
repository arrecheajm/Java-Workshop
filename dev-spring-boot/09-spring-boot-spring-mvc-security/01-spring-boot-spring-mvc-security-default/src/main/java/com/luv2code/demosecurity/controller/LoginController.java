package com.luv2code.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This controlling contains logging and security mappings
@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "fancy-login";
    }

    // add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){

        return "access-denied";
    }
}
