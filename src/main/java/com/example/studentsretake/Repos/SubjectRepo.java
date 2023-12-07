package com.example.studentsretake.Repos;

import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
