package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Repos.StudentRepo;
import com.example.studentsretake.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public Student create(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student read(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public Student readByUser(User user) {
        return studentRepo.findByUser(user);
    }

    @Override
    public Student update(Long id, Student newStudent) {
        Student studentFromBd = studentRepo.findById(id).orElseThrow();

        studentFromBd.setDebts(newStudent.getDebts());
        studentFromBd.setCode(newStudent.getCode());
        studentFromBd.setFirstName(newStudent.getFirstName());
        studentFromBd.setLastName(newStudent.getLastName());
        studentFromBd.setGroup(newStudent.getGroup());
        studentFromBd.setPerformances(newStudent.getPerformances());

        return studentRepo.save(studentFromBd);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepo.findById(studentId).orElseThrow();
    }
}
