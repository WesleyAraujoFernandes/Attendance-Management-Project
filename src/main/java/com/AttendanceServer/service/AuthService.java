package com.AttendanceServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AttendanceServer.entities.User;
import com.AttendanceServer.enums.UserRole;
import com.AttendanceServer.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser() {
        User optionalUser = userRepository.findByUserRole(UserRole.ADMIN);

        if (optionalUser == null) {
            User user = new User();

            user.setName("Admin");
            user.setEmail("admin@gmail.com");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword("admin");

            userRepository.save(user);
            System.out.println("Admin user created");
        } else {
            System.out.println("Admin user already exists");
        }
    }
}
