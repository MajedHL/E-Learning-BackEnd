package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.models.Enrollement;
import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.repositories.CourseRepository;
import com.mh.api.MhAPI.repositories.EnrollmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Course> getCoursesByUser(String username){

       return courseRepository.getCoursesByUser(username);
    }

    public void enroll(Long courseId, User user){
        Enrollement enrollement = new Enrollement();
        Course course = entityManager.getReference(Course.class, courseId);
        enrollement.setCourse(course);
        enrollement.setUser(user);
        enrollement.setEnrollementDate(LocalDate.now());
        enrollmentRepository.save(enrollement);
    }
}
