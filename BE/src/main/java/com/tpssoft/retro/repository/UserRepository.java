package com.tpssoft.retro.repository;

import com.tpssoft.retro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByToken(String token);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

}