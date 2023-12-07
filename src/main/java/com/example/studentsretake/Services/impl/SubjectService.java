package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Group;
import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.Teacher;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Repos.SubjectRepo;
import com.example.studentsretake.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepo subjectRepo;
    private final GroupService groupService;


    @Autowired
    public SubjectService(SubjectRepo subjectRepo, GroupService groupService) {
        this.subjectRepo = subjectRepo;
        this.groupService = groupService;
    }

    public Teacher getTeacherBySubject(Long subjectId, Long groupId) {
        Subject subject = subjectRepo.findById(subjectId).orElseThrow();
        Group group = groupService.get(groupId);
        for (Teacher teacher : subject.getTeachers()){
            for (Group teacherGroup : teacher.getGroups()){
                if (teacherGroup.equals(group))
                    return teacher;
            }
        }
        return null;
    }

    public Subject create(Subject subject){
        return subjectRepo.save(subject);
    }


    public void remove(Long id) {
        subjectRepo.findById(id).ifPresent(subject -> {
            System.out.println(subject.getTeachers());
            subject.getTeachers().clear();
            subjectRepo.save(subject);
        });
        subjectRepo.deleteById(id);
    }

    public void save(Subject subject){
        subjectRepo.save(subject);
    }

    public Subject getSubjectFromBd(Long subjectId) {
        return subjectRepo.findById(subjectId).orElse(null);
    }



    public List<Teacher> getTeachers(Long subjectId){
        Subject subject = subjectRepo.findById(subjectId).orElseThrow();
        return subject.getTeachers();
    }

    public List<Subject> getAll(){
        return subjectRepo.findAll();
    }
}
