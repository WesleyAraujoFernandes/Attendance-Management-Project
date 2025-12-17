package com.AttendanceServer.entities;

import java.util.Date;

import com.AttendanceServer.dto.ProjectDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String duration;
    private Date startDate;

    public ProjectDTO getDto() {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDuration(this.duration);
        dto.setStartDate(this.startDate);
        return dto;
    }
}
