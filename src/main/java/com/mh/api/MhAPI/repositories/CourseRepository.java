package com.mh.api.MhAPI.repositories;


import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.projections.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT c.* FROM course c, user_course_set e, client u WHERE u.id=e.user_id AND e.course_id=c.id AND u.email=?1", nativeQuery = true)
    public List<Course> getCoursesByUser(String username);
    @Query(value = "select * from course where id in (select id from course EXCEPT select e.course_id from user_course_set e right join client c on c.id=e.user_id where c.email =?1)", nativeQuery = true)
    public List<CourseProjection> getAllCoursesNotEnrolled(String username);
    @Query(value = "SELECT * from course", nativeQuery = true)
    public List<CourseProjection> findAllAsProjections();


}
