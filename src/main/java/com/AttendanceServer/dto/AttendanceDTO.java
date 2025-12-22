package com.AttendanceServer.dto;

import java.time.LocalDate;

import com.AttendanceServer.entities.Project;
import com.AttendanceServer.enums.AttendanceStatus;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AttendanceDTO {
    private Long id;
    private LocalDate date;
    private AttendanceStatus status;
    private Long projectId;
    private String projectName;
    private Long employeeId;
    private String employeeName;
    private Long managerId;
    private String managerName;
}
