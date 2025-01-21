package com.mh.api.MhAPI.repositories;

import com.mh.api.MhAPI.models.Course;
import com.mh.api.MhAPI.models.Enrollement;
import com.mh.api.MhAPI.models.EnrollementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollement, EnrollementId> {



}
