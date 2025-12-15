package com.AttendanceServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AttendanceServer.entities.User;
import com.AttendanceServer.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserRole(UserRole userRole);

}
