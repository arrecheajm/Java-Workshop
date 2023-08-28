package com.luv2code.springdemo.mvc;


import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    // Add initbinder ... to convert trim input string
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor // Removes whitespace - leading trailing
                = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, // Use the editor for the String.class
                                        stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){

        theModel.addAttribute("customer", new Customer());

        return "customer-form"; // Mapping to html form
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid //Valid tells Spring mvc to perform validation
            @ModelAttribute("customer") Customer theCustomer, //HTML model with validation rules
            BindingResult theBindingResult){ //Hold the results of validation

//        System.out.println("Last Name: |"+theCustomer.getLastName()+"|");
        System.out.println("Binding Result: "+ theBindingResult.toString());
        if(theBindingResult.hasErrors()){
            return "customer-form"; //Failed, return to form
        } else {
            return "customer-confirmation"; //Success confirmation page
        }
    }
}
