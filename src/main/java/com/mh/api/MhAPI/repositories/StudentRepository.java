package com.mh.api.MhAPI.repositories;

import com.mh.api.MhAPI.models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "SELECT * FROM students where email = ?1", nativeQuery = true)
    Optional<Student> findStudentByEmail(String email);
}
