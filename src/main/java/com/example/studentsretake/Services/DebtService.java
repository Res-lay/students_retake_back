package com.example.studentsretake.Services;

import com.example.studentsretake.Entities.Debt;
import com.example.studentsretake.Entities.Student;

import java.util.List;

public interface DebtService {
    Debt create(Debt debt);
    Debt read(Integer id);
    List<Debt> readStudentDebts(Student student);
    Debt update(Integer id, Debt newDebt);
    void delete(Integer id);

}
