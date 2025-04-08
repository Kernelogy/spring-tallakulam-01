package com.edex.commerce.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// https://www.google.com/
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class DummyController {

    @GetMapping("/hi")
    public String sayHi(){
        return "Hello World";
    }
    @GetMapping("/pi")
    public Double getPi(){
        return 3.14;
    }    
    @PostMapping("/login")
    public String login(){
        return "Login Success";
    }

}
