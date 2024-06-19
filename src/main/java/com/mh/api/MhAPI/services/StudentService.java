package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.Student;
import com.mh.api.MhAPI.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    protected final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public String addStudent(Student student){
       if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
           return "Student exist";
       }
        studentRepository.save(student);
       return "Student created";
    }

    public String deleteStudent(Long id){
     if(!studentRepository.existsById(id)){
         return "Student with id "+id+" doesnt exist";
     }
        studentRepository.deleteById(id);
     return "Student with id "+id+" deleted";
    }


    public String updateStudent(Long id, Student newStudent){
        String message=" student with id "+id+" has been updated";
        if(!studentRepository.existsById(id)){
            message = "Student with id "+id+" doesnt exist, a new student has been created";
        }
        studentRepository.save(newStudent);
        return message;
    }
}
