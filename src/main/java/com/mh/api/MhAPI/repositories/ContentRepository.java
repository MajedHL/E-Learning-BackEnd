package com.mh.api.MhAPI.repositories;

import com.mh.api.MhAPI.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {


}
