package com.frhd.userjobservice.Repository;

import com.frhd.userjobservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries can be added here if needed
    Optional <User> findByUserId(String userId);
}
