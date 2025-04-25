package com.edex.commerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.commerce.dto.request.Login;
import com.edex.commerce.dto.request.UserRequestDto;
import com.edex.commerce.model.User;
import com.edex.commerce.repo.UserRepo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
    @PostMapping("/insert")
    public User insert(@RequestBody UserRequestDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAvatar(dto.getAvatar());
        user.setCreatedAt(new Date());
        User savedObj = userRepo.saveAndFlush(user);
        return savedObj;
    }
    @GetMapping("/list")
    public List<User> listUsers(){
        List<User> users = userRepo.findAll();
        return users;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        // User user = userRepo.findById(id).get();        
        User user = userRepo.findByUserId(id);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<List<User>> getUsername(@PathVariable String username){
        List<User> users = userRepo.findByUsername(username);       
        return ResponseEntity.ok().body(users);
    }
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody Login dto){
        User user = userRepo.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(user != null){
            return ResponseEntity.ok().body("Success");
        }else{
            return ResponseEntity.ok().body("Failed");
        }
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userRepo.deleteById(id);       
        return ResponseEntity.ok().body("Success");
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserRequestDto dto){
        User user = userRepo.findById(dto.getId()).get();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAvatar(dto.getAvatar());
        userRepo.saveAndFlush(user);
        return ResponseEntity.ok().body("User Updated Successfully");
    }

}
