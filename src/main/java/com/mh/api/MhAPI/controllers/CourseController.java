package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/course")
public class CourseController {


    protected final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<Course> getAllCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping(path = "{courseId}")
    public Course getCourseById(@PathVariable("courseId") Long id){
        return this.courseService.getCourseById(id);
    }

    @PostMapping()
    public Course addCourse(@RequestBody Course course){
       return this.courseService.addCourse(course);
    }
}
