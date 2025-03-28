package com.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.dao.UserRepository;
import com.api.entities.User;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Add a New User
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    /*
    // ✅ Add User Login Information
    @PostMapping(value="/login")
    public Userlogin addUserlogin(@RequestBody Userlogin userd) {
        return userloginRepository.save(userd);
    }
    */
}
