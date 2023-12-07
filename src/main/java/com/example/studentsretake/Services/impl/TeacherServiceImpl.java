package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.Teacher;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Repos.TeacherRepo;
import com.example.studentsretake.Services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher read(Long id) {
        return teacherRepo.findById(id).orElseThrow();
    }


    @Override
    public Teacher update(Long id, Teacher newStudent) {
        return null;
    }

    @Override
    public void delete(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Teacher getById(Long teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow();
    }

    @Override
    public List<Subject> getTeacherSubjects(Long teacherId) {
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow();
        return teacher.getSubjects();
    }
}
