package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Debt;
import com.example.studentsretake.Entities.Performance;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Repos.PerformanceRepo;
import com.example.studentsretake.Services.DebtService;
import com.example.studentsretake.Services.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepo performanceRepo;
    private final SubjectService subjectService;
    private final DebtService debtService;

    @Override
    public void createPerformance(Student student) {
        List<Subject> subjects = subjectService.getAll();
        Random random = new Random();
        for (int i = 1; i < subjects.size() - 10; i ++ ){
            if (student.getGroup().getName().equals("UEBO-30-20")){
                if (i % 3 == 0){
                    Debt debt = Debt.builder().term(1 + random.nextInt(student.getTerm())).student(student)
                            .retakeDay(LocalDate.now().minusMonths(6))
                            .subject(subjects.get(i)).build();
                    debtService.create(debt);
                }else{
                    Performance performance = Performance.builder().mark(random.nextInt(3) + 3)
                            .term(random.nextInt(1 + student.getTerm())).student(student)
                            .subject(subjects.get(i)).build();
                    performanceRepo.save(performance);
                }
            }else if (student.getGroup().getName().equals("IKBO-16-21")){
                if (i % 5 == 0){
                    Debt debt = Debt.builder().term(1 + random.nextInt(student.getTerm())).student(student)
                            .retakeDay(LocalDate.now().minusMonths(6))
                            .subject(subjects.get(i)).build();
                    debtService.create(debt);
                }else{
                    Performance performance = Performance.builder().mark(random.nextInt(4) + 2)
                            .term(random.nextInt(1 + student.getTerm())).student(student)
                            .subject(subjects.get(i)).build();
                    performanceRepo.save(performance);
                }

            }else{
                if (i % 4 == 0){
                    Debt debt = Debt.builder().term(1 + random.nextInt(student.getTerm())).student(student)
                            .retakeDay(LocalDate.now().minusMonths(6))
                            .subject(subjects.get(i)).build();
                    debtService.create(debt);
                }else{
                    Performance performance = Performance.builder().mark(random.nextInt(3) + 3)
                            .term(random.nextInt(1 + student.getTerm())).student(student)
                            .subject(subjects.get(i)).build();
                    performanceRepo.save(performance);
                }
            }
        }
    }

    @Override
    public Performance create(Performance performance) {
        return performanceRepo.save(performance);
    }

    @Override
    public Performance read(Long id) {
        return performanceRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Performance> readByStudent(Student student) {
        return performanceRepo.findAllByStudent(student);
    }

    @Override
    public Performance update(Long id, Performance newPerformance) {
        Performance performanceFromDb = performanceRepo.findById(id).orElseThrow();
        performanceFromDb.setMark(newPerformance.getMark());
        performanceFromDb.setStudent(newPerformance.getStudent());
        performanceFromDb.setSubject(newPerformance.getSubject());

        return performanceRepo.save(performanceFromDb);
    }

    @Override
    public void delete(Long id) {
        performanceRepo.deleteById(id);
    }
}
