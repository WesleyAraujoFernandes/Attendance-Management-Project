package com.AttendanceServer.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AttendanceServer.dto.AttendanceDTO;
import com.AttendanceServer.entities.Attendance;
import com.AttendanceServer.entities.Project;
import com.AttendanceServer.entities.User;
import com.AttendanceServer.repository.AttendanceRespository;
import com.AttendanceServer.repository.ProjectRepository;
import com.AttendanceServer.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRespository attendanceRespository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public AttendanceDTO markAttendance(AttendanceDTO dto) {
        Optional<User> optionalEmployee = userRepository.findById(dto.getEmployeeId());
        Optional<User> optionalManager = userRepository.findById(dto.getManagerId());
        Optional<Project> optionalProject = projectRepository.findById(dto.getProjectId());
        if (optionalEmployee.isPresent() && optionalManager.isPresent() && optionalProject.isPresent()) {
            Attendance attendance = new Attendance();
            attendance.setDate(LocalDate.now());
            attendance.setAttendanceStatus(dto.getAttendanceStatus());
            attendance.setEmployee(optionalEmployee.get());
            attendance.setProject(optionalProject.get());
            attendance.setManager(optionalManager.get());
            return attendanceRespository.save(attendance).getDto();
        } else {
            throw new EntityNotFoundException("Employee, Manager, or Project Not Found");
        }
    }
}
