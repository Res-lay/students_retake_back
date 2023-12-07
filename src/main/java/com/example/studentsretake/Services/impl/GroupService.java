package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Group;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Repos.GroupRepo;
import com.example.studentsretake.dao.request.GroupFormRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepo groupRepo;
    @Autowired
    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public Group create(GroupFormRequest request){
        Group group = Group.builder().name(request.getGroupName()).build();
        return groupRepo.save(group);
    }

    public Group update(Group newGroup, Long groupId){
        Group group = groupRepo.findById(groupId).orElse(null);
        group.setName(newGroup.getName());
        group.setStudents(newGroup.getStudents());
        return groupRepo.save(group);
    }

    public void addStudent(Long groupId, Student student){
        Group group = groupRepo.findById(groupId).orElse(null);
        group.getStudents().add(student);
        groupRepo.save(group);
    }

    public String delete(Long id){
        Group group = groupRepo.findById(id).orElse(null);
        group.getStudents().clear();
        groupRepo.save(group);
        groupRepo.deleteById(id);
        return "deleted";
    }

    public List<Group> getAll(){
        return groupRepo.findAll();
    }

    public Group get(Long groupId) {
        return groupRepo.findById(groupId).orElse(null);
    }

    public Group getByName(String groupName) {
        return groupRepo.findByName(groupName);
    }
}
