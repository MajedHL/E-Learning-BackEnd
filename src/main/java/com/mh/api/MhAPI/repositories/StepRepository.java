package com.mh.api.MhAPI.repositories;

import com.mh.api.MhAPI.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
}
