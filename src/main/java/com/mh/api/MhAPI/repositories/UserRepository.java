package com.mh.api.MhAPI.repositories;

import com.mh.api.MhAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM client where email = ?1", nativeQuery = true)
    Optional<User> findUserByEmail(String email);

}
