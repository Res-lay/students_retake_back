package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.Teacher;
import com.example.studentsretake.Services.impl.SubjectService;
import com.example.studentsretake.Services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SubjectController {

    private final SubjectService subjectService;
    private final UserService userService;

    @Autowired
    public SubjectController(SubjectService subjectService, UserService userService) {
        this.subjectService = subjectService;
        this.userService = userService;
    }

    @PostMapping("/admin/add-subject")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject){
        Subject savedSubject = subjectService.create(subject);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSubject.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedSubject);
    }
    @DeleteMapping("/admin/remove-subject/{id}")
    public ResponseEntity<?> removeSubject(@PathVariable Long id){
        subjectService.remove(id);
        return ResponseEntity.ok().body("Deleted");
    }

    @GetMapping("/api/user/get-teacher")
    public Teacher getTeacherBySubject(@RequestParam Long subjectId,
                                       @RequestParam Long groupId){
        Teacher teacher = subjectService.getTeacherBySubject(subjectId, groupId);
        return teacher;
    }

    @GetMapping("/api/user/subject")
    public Subject getSubjectInfo(@RequestParam Long subjectId){
        return subjectService.getSubjectFromBd(subjectId);
    }

    @GetMapping("/api/user/subject/teachers")
    public List<Teacher> getSubjectTeachers(@RequestParam Long subjectId){
        return subjectService.getTeachers(subjectId);
    }
}
