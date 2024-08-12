package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.repositories.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    protected final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<Long> addUser(User user){
        Optional<User> checkUser = userRepository.findUserByEmail(user.getEmail());
        if(checkUser.isPresent()){
           return  ResponseEntity.status(409).body(checkUser.get().getId());
       }
        userRepository.save(user);
       return ResponseEntity.status(201).body(user.getId());

    }

    public String deleteUser(Long id){
     if(!userRepository.existsById(id)){
         return "User with id "+id+" doesnt exist";
     }
        userRepository.deleteById(id);
     return "User with id "+id+" deleted";
    }


    public String updateUser(Long id, User newUser){
        String message=" user with id "+id+" has been updated";
        if(!userRepository.existsById(id)){
            message = "user with id "+id+" doesnt exist, a new user has been created";
        }
        userRepository.save(newUser);
        return message;
    }
}
