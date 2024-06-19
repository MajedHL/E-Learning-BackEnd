package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.models.Student;
import com.mh.api.MhAPI.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    protected final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @PostMapping()
    public String addStudent(@RequestBody Student student){
       return studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long id){
        return studentService.deleteStudent(id);
    }


    @PutMapping(path = "{studentId}")
    public String updateStudent(@PathVariable("studentId") Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
