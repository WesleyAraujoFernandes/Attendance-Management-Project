package com.AttendanceServer.entities;

import com.AttendanceServer.dto.UserDTO;
import com.AttendanceServer.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public UserDTO getDto() {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setName(name);
        dto.setPassword(password);
        dto.setEmail(email);
        dto.setUserRole(userRole);
        return dto;
    }
}
