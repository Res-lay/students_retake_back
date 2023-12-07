package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Debt;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Services.DebtService;
import com.example.studentsretake.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DebtController {

    private final DebtService debtService;
    private final StudentService studentService;

    @GetMapping("/api/student/debts")
    public List<Debt> getDebts(@RequestParam Long studentId){
        Student student = studentService.read(studentId);
        return debtService.readStudentDebts(student);
    }
}
