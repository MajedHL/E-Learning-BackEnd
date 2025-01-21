package com.mh.api.MhAPI.controllers;


import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.models.Step;
import com.mh.api.MhAPI.projections.CourseProjection;
import com.mh.api.MhAPI.services.CourseService;
import com.mh.api.MhAPI.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "api/course")
@Slf4j
public class CourseController {


    protected final CourseService courseService;
    protected final UserService userService;
    @Autowired
    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping()
    public List<CourseProjection> getAllCourses(){
      try {
          String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
           userService.getUserByUsername(username);//throws exception if not found
           return this.courseService.getAllNotEnrolledCourses(username);
      }catch (NoSuchElementException e){
          log.debug(e.getMessage());
          return this.courseService.getAllCourses();
      }

    }

    @GetMapping(path = "/{courseId}")
    public Course getCourseById(@PathVariable("courseId") Long id){
        return this.courseService.getCourseById(id);
    }

    @PostMapping()
    public Course addCourse(@RequestBody Course course){
       return this.courseService.addCourse(course);
    }
}
