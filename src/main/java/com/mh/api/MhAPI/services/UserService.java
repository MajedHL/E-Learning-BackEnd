package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String addUser(User user){
       if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
           return "User exist";
       }
        userRepository.save(user);
       return "User created";
    }

    public String deleteUser(Long id){
     if(!userRepository.existsById(id)){
         return "User with id "+id+" doesnt exist";
     }
        userRepository.deleteById(id);
     return "User with id "+id+" deleted";
    }


    public String updateUser(Long id, User newUser){
        String message=" student with id "+id+" has been updated";
        if(!userRepository.existsById(id)){
            message = "Student with id "+id+" doesnt exist, a new student has been created";
        }
        userRepository.save(newUser);
        return message;
    }
}
