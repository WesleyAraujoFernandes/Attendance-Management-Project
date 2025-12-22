package com.AttendanceServer.entities;

import java.time.LocalDate;

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
    private AttendanceStatus status;
    @ManyToOne
    private Project project;
    @ManyToOne
    private User employee;
    @ManyToOne
    private User manager;
}
