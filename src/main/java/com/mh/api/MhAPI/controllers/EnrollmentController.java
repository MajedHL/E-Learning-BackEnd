package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.services.EnrollmentService;
import com.mh.api.MhAPI.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final UserService userService;
    public EnrollmentController(EnrollmentService enrollmentService, UserService userService) {
        this.enrollmentService = enrollmentService;
        this.userService = userService;
    }

    @GetMapping()
    public List<Course> getCoursesByUser(){
     String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return enrollmentService.getCoursesByUser(username);
    }

    @PostMapping(path = "/{courseId}")
    public void enroll(@PathVariable("courseId") Long courseId){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         User user =  userService.getUserByUsername(username);
        enrollmentService.enroll(courseId, user);
    }
}
