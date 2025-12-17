package com.AttendanceServer.entities;

import com.AttendanceServer.dto.UserDTO;
import com.AttendanceServer.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private UserRole userRole;
    @ManyToOne
    private Project project;

    public UserDTO getDto() {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setName(name);
        dto.setPassword(password); // Consider security implications
        dto.setEmail(email);
        dto.setUserRole(userRole);
        if (project != null) {
            dto.setProjectId(project.getId());
            dto.setProjectName(project.getName());
        }
        return dto;
    }
}
