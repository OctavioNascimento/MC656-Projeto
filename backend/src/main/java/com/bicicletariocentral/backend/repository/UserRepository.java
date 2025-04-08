package com.bicicletariocentral.backend.repository;

import com.bicicletariocentral.backend.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}