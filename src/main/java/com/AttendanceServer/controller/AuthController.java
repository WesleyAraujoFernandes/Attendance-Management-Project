package com.AttendanceServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AttendanceServer.dto.UserDTO;
import com.AttendanceServer.service.AuthService;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        UserDTO dbUser = authService.login(user);
        if (dbUser == null) {
            return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(dbUser, HttpStatus.OK);
    }
}
