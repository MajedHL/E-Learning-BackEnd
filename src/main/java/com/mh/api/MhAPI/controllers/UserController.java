package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.dto.UserDTO;
import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/user")
@Slf4j
public class UserController {

    protected final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers(){
        log.info("Getting all users");
        return userService.getAllUsers();
    }


    @DeleteMapping(path = "/{userId}")
    public String deleteUser(@PathVariable("userId") Long id){
        return userService.deleteUser(id);
    }


    @PutMapping(path = "/{userId}")
    public String updateUser(@PathVariable("userId") Long id, @RequestBody @Valid UserDTO  userDto){
        // a projection of the user model could have been used instead of the dto
        return userService.updateUser(id, userDto);
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") Long id){
        // a projection of the user model could have been used instead of the dto
        return userService.getUserById(id);
    }



    @GetMapping(path = "/current")
    public Map<String, Object> getCurrentUserName(){
       String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      Map<String, Object> map = new HashMap<>();
      map.put("firstName",userService.getUserFirstNameByUsername(username));

       return map;
    }
}
