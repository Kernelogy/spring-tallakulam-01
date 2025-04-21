package com.edex.commerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.commerce.dto.request.Login;
import com.edex.commerce.model.User;
import com.edex.commerce.repo.UserRepo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        /*
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
        return ResponseEntity.ok()
        .body("Success");
        */
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")){
            return ResponseEntity.ok()
            .body("Success");
        }else{
            return ResponseEntity.ok()
            .body("Failed");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login user){
        String username = user.getUsername();
        String password = user.getPassword();
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")){
            return ResponseEntity.ok()
            .body("Success");
        }else{
            return ResponseEntity.ok()
            .body("Failed");
        }       

    }

    @Autowired
    private UserRepo userRepo;
    
    @GetMapping("/insert")
    public User insert(){
        User user = new User();
        user.setUsername("mukilan");
        user.setPassword("12345");
        user.setFirstName("Karumukilan");
        user.setLastName("Subbiah");
        user.setAvatar("image.jpg");
        user.setCreatedAt(new Date());
        User savedObject = userRepo.saveAndFlush(user);
        return savedObject;
    }

}
