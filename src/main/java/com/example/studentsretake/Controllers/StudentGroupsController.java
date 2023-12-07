package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Group;
import com.example.studentsretake.Services.impl.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student/groups")
@RequiredArgsConstructor
public class StudentGroupsController {

    private final GroupService groupService;

    @GetMapping("/get-all")
    public List<Group> getGroups(){
        return groupService.getAll();
    }
}
