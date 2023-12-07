package com.example.studentsretake.Services;

import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.User;

public interface StudentService {
    Student create(Student student);
    Student read(Long id);
    Student readByUser(User user);
    Student update(Long id, Student newStudent);
    void delete(Long id);

    Student getById(Long studentId);
}
