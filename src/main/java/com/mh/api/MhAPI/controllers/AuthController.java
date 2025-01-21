package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.services.AuthService;
import com.mh.api.MhAPI.utils.MHException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/signUp")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user){
        Map<String, Object> response = new HashMap<>();
        try{
            String password = user.getPassword();;
            authService.registerUser(user);
            response.put("token",authService.authenticateUser(user.getEmail(), password));
            return ResponseEntity.ok(response);
        }catch (Exception e){
           if(e instanceof MHException){
               response.put("message",e.getMessage());
               response.put("code", ((MHException) e).getCode());
               return ResponseEntity.status(400).body(response);
           }
            response.put("message",e.getMessage());
            response.put("code", 409);
            return ResponseEntity.status(409).body(response);
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, Object> payload){
        Map<String, String> response = new HashMap<>();
        try{
        String username = (String) payload.get("username");
        String password = (String) payload.get("password");

        response.put("token",authService.authenticateUser(username,password));
        return ResponseEntity.ok(response);
    }catch (Exception e){
        response.put("Error",e.getMessage());
        return ResponseEntity.status(409).body(response);
    }

    }



}
