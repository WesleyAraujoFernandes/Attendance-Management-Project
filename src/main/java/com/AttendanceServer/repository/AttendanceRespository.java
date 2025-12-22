package com.AttendanceServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AttendanceServer.entities.Attendance;

@Repository
public interface AttendanceRespository extends JpaRepository<Attendance, Long> {

}
