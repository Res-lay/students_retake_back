package com.example.studentsretake.Repos;

import com.example.studentsretake.Entities.Debt;
import com.example.studentsretake.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtRepo extends JpaRepository<Debt, Integer> {
    List<Debt> findDebtsByStudent(Student student);
}
