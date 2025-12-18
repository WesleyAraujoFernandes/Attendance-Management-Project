package com.AttendanceServer.controller;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AttendanceServer.dto.UserDTO;
import com.AttendanceServer.service.AdminService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-user")
    public ResponseEntity<?> signupUser(@RequestBody UserDTO dto) {
        try {
            return ResponseEntity.ok(adminService.createUser(dto));
        } catch (EntityExistsException | EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>("User not created, come again later" + e.getMessage(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/managers")
    public ResponseEntity<?> getAllManagers() {
        try {
            return ResponseEntity.ok(adminService.getAllManagers());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving managers: " + e.getMessage());
        }
    }
}
