package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Debt;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Repos.DebtRepo;
import com.example.studentsretake.Repos.StudentRepo;
import com.example.studentsretake.Services.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final DebtRepo debtRepo;
    private final StudentRepo studentRepo;

    @Override
    public Debt create(Debt debt) {
        return debtRepo.save(debt);
    }

    @Override
    public Debt read(Integer id) {
        return debtRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Debt> readStudentDebts(Student student) {
        return debtRepo.findDebtsByStudent(student);
    }

    @Override
    public Debt update(Integer id, Debt newDebt) {
        Debt debtFromRepo = debtRepo.findById(id).orElseThrow();
        debtFromRepo.setTerm(newDebt.getTerm());
        debtFromRepo.setSubject(newDebt.getSubject());
        debtFromRepo.setStudent(newDebt.getStudent());
        debtFromRepo.setRetakeDay(newDebt.getRetakeDay());

        return debtRepo.save(debtFromRepo);
    }

    @Override
    public void delete(Integer id) {
        debtRepo.deleteById(id);
    }
}
