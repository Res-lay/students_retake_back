package com.example.studentsretake.Repos;

import com.example.studentsretake.Entities.Performance;
import com.example.studentsretake.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceRepo extends JpaRepository<Performance, Long> {
    List<Performance> findAllByStudent(Student student);
}
