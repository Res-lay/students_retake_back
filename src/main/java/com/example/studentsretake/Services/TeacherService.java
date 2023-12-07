package com.example.studentsretake.Services;

import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.Teacher;
import com.example.studentsretake.Entities.User;

import java.util.List;

public interface TeacherService {
    Teacher create(Teacher teacher);
    Teacher read(Long id);
    Teacher update(Long id, Teacher newTeacher);
    void delete(Long id);

    Teacher getById(Long teacherId);

    List<Subject> getTeacherSubjects(Long teacherId);
}
