package com.mh.api.MhAPI.repositories;

import com.mh.api.MhAPI.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    @Query(value = "Select * from content where step_id = ?1",nativeQuery = true)
    public List<Content> getContentListByStepId(Long stepId);
}
