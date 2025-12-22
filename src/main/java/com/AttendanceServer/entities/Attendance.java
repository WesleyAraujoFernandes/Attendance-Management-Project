package com.AttendanceServer.entities;

import java.time.LocalDate;

import com.AttendanceServer.dto.AttendanceDTO;
import com.AttendanceServer.enums.AttendanceStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private AttendanceStatus attendanceStatus;
    @ManyToOne
    private Project project;
    @ManyToOne
    private User employee;
    @ManyToOne
    private User manager;

    public AttendanceDTO getDto() {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setId(this.id);
        dto.setDate(this.date);
        dto.setAttendanceStatus(this.attendanceStatus);
        if (this.project != null) {
            dto.setProjectId(this.project.getId());
            dto.setProjectName(this.project.getName());
        }
        if (this.employee != null) {
            dto.setEmployeeId(this.employee.getId());
            dto.setEmployeeName(this.employee.getName());
        }
        if (this.manager != null) {
            dto.setManagerId(this.manager.getId());
            dto.setManagerName(this.manager.getName());
        }
        return dto;
    }
}
