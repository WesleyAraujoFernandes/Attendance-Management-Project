package com.AttendanceServer.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private String duration;
    private Date startDate;
}
