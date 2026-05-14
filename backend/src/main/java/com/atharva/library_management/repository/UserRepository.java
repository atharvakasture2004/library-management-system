package com.atharva.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atharva.library_management.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
