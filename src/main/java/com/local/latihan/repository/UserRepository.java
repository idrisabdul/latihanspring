package com.local.latihan.repository;

import com.local.latihan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM users WHERE token = ?1", nativeQuery = true)
    Optional<User> findFirstByToken(String token);

}
