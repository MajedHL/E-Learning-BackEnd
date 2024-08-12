package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    protected final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @PostMapping()
    public ResponseEntity<Long> addUSer(@RequestBody User user){
        return  userService.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public String deleteUser(@PathVariable("userId") Long id){
        return userService.deleteUser(id);
    }


    @PutMapping(path = "{userId}")
    public String updateUser(@PathVariable("userId") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
