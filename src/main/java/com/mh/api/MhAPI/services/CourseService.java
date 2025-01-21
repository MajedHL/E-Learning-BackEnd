package com.mh.api.MhAPI.services;


import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.models.Step;
import com.mh.api.MhAPI.projections.CourseProjection;
import com.mh.api.MhAPI.repositories.CourseRepository;
import com.mh.api.MhAPI.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    protected final CourseRepository courseRepository;


    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    // all courses that the user didn't enroll in
    @Transactional
    public List<CourseProjection> getAllNotEnrolledCourses(String username){
        return courseRepository.getAllCoursesNotEnrolled(username);
    }
    @Transactional
    public List<CourseProjection> getAllCourses(){
        return courseRepository.findAllAsProjections();
    }

    public Course addCourse(Course course){return this.courseRepository.save(course);}

    public Course getCourseById(Long courseId){
        return this.courseRepository.findById(courseId).orElseThrow(()-> new NoSuchElementException());
    }


}
