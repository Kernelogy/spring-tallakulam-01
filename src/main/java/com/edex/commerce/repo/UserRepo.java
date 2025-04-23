package com.edex.commerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edex.commerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);
    List<User> findByFirstName(String firstName);
    User findByUsernameAndPassword(String username, String password);
    List<User> findByUsernameOrPassword(String username, String password);

    @Query(value = "select * from users where id = ?1", nativeQuery = true)
    User findByUserId(int id);
    
} 
/*
select * from users // findAll
select * from users where id = 1 // fndById
select * from users where username = 'mukilan' // findByUsername
select * from users where username = 'mukilan' and password = '12345' // findByUsernameAndPassword
select * from users where username = 'mukilan' or password = '12345' // findByUsernameOrPassword

*/