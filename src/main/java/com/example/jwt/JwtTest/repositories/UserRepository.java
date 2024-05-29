package com.example.jwt.JwtTest.repositories;

import com.example.jwt.JwtTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
