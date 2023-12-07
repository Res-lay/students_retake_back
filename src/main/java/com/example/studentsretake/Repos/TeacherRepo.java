package com.example.studentsretake.Repos;

import com.example.studentsretake.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,  Long> {
}
