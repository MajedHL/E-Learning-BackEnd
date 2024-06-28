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

    public List<User> getAllStudents(){
        return userRepository.findAll();
    }

    public String addStudent(User user){
       if(userRepository.findStudentByEmail(user.getEmail()).isPresent()){
           return "Student exist";
       }
        userRepository.save(user);
       return "Student created";
    }

    public String deleteStudent(Long id){
     if(!userRepository.existsById(id)){
         return "Student with id "+id+" doesnt exist";
     }
        userRepository.deleteById(id);
     return "Student with id "+id+" deleted";
    }


    public String updateStudent(Long id, User newUser){
        String message=" student with id "+id+" has been updated";
        if(!userRepository.existsById(id)){
            message = "Student with id "+id+" doesnt exist, a new student has been created";
        }
        userRepository.save(newUser);
        return message;
    }
}
