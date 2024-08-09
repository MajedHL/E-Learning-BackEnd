package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    protected final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }


    public Course addCourse(Course course){return this.courseRepository.save(course);}

    public Course getCourseById(Long courseId){
        return this.courseRepository.findById(courseId).orElse(null);
    }
}
