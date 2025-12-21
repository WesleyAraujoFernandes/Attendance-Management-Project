package com.AttendanceServer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AttendanceServer.entities.User;
import com.AttendanceServer.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserRole(UserRole userRole);

    Optional<User> findByEmail(String email);

    List<User> findAllByUserRole(UserRole userRole);

    List<User> findAllByProjectIdAndUserRole(Long projectId, UserRole userRole);
}
