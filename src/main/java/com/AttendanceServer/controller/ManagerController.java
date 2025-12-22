package com.AttendanceServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AttendanceServer.service.ManagerService;

@RestController
@RequestMapping("/managers")
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/employees/{projectId}")
    public ResponseEntity<?> getAllEmployeesByProject(@PathVariable Long projectId) {
        try {
            return ResponseEntity.ok(managerService.getAllEmployeesByProject(projectId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving employees: " + e.getMessage());
        }
    }
}
