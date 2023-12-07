package com.example.studentsretake.Repos;

import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByUser(User user);

}
