package com.api.controller;

import com.api.dao.UserloginRepository;
import com.api.entities.Userlogin;
import com.api.utils.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserloginRepository userloginRepository;

    // ✅ User Registration with File Upload
    @PostMapping("/register")
    public String registerUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("mobile") String mobile,
            
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("resume") MultipartFile resume) {

        try {
            // ✅ Validate Photo
       
            String photoError = ValidationUtil.validatePhoto(photo);
            if (photoError != null) return photoError;

            // ✅ Validate Resume
            String resumeError = ValidationUtil.validateResume(resume);
            if (resumeError != null) return resumeError;
         
            // ✅ Convert Files to Bytes
            
            byte[] photoBytes = photo.getBytes();
            byte[] resumeBytes = resume.getBytes();

            // ✅ Save User in Database
            Userlogin user = new Userlogin(name, mobile, email, address, photoBytes, resumeBytes);
            userloginRepository.save(user);
            return "User registered successfully!";
        } catch (IOException e) {
            return "Error while saving files.";
        }
    }

    // ✅ Get All Registered Users
    @GetMapping("/users")
    public Iterable<Userlogin> getAllUsers() {
        return userloginRepository.findAll();
    }

    // ✅ Get User By ID
    @GetMapping("/user/{id}")
    public Userlogin getUserById(@PathVariable Integer id) {
        return userloginRepository.findById(id).orElse(null);
    }

    // ✅ Delete User By ID
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        if (userloginRepository.existsById(id)) {
            userloginRepository.deleteById(id);
            return "User deleted successfully!";
        } else {
            return "User not found!";
        }
    }
}
