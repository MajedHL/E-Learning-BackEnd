package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class UserController {

    protected final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> getAllStudents(){
        return userService.getAllStudents();
    }


    @PostMapping()
    public String addStudent(@RequestBody User user){
       return userService.addStudent(user);
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long id){
        return userService.deleteStudent(id);
    }


    @PutMapping(path = "{studentId}")
    public String updateStudent(@PathVariable("studentId") Long id, @RequestBody User user){
        return userService.updateStudent(id, user);
    }
}
