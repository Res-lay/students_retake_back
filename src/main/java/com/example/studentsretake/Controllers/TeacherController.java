package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.Teacher;
import com.example.studentsretake.Services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/api/user/teachers/teacher")
    public Teacher getTeacher(@RequestParam Long teacherId){
        return teacherService.getById(teacherId);
    }
    @GetMapping("/api/user/teacher/subjects")
    public List<Subject> getSubjects(@RequestParam Long teacherId){
        return teacherService.getTeacherSubjects(teacherId);
    }
}
