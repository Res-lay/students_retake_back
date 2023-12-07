package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Group;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.Subject;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Services.impl.GroupService;
import com.example.studentsretake.Services.impl.StudentServiceImpl;
import com.example.studentsretake.Services.impl.SubjectService;
import com.example.studentsretake.Services.impl.UserService;
import com.example.studentsretake.dao.request.GroupFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/groups")
public class GroupController {

    private final GroupService groupService;
    private final UserService userService;
    private final StudentServiceImpl studentService;
    private final SubjectService subjectService;


    @PostMapping("/add-group")
    public ResponseEntity<?> createGroup(@RequestBody GroupFormRequest request){
        Group newGroup = groupService.create(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newGroup.getId())
                .toUri();
        return ResponseEntity.created(location).body(newGroup);
    }

    @DeleteMapping("/delete-group")
    public ResponseEntity<?> deleteGroup(@RequestParam Long id){
        groupService.delete(id);
        return ResponseEntity.ok("Group deleted");
    }

    @PutMapping("/add-student")
    public ResponseEntity<?> addStudentToGroup(@RequestBody GroupFormRequest request){
        Group group = groupService.get(request.getGroupId());
        Student student = studentService.read(request.getStudentId());
        if (group != null && student != null){
            student.setGroup(group);
            group.getStudents().add(student);
            groupService.update(group, request.getGroupId());
            studentService.update(request.getStudentId(), student);
            return ResponseEntity.ok("Student was added successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/admin/group-student/remove")
    public ResponseEntity<?> deleteStudentFromGroup(@RequestParam Long groupId,
                                               @RequestParam Long studentId){

        Group group = groupService.get(groupId);
        Student student = studentService.read(studentId);

        if (group != null && student != null){
            group.getStudents().clear();
            student.setGroup(null);
            groupService.update(group, groupId);
            studentService.create(student);
            return ResponseEntity.ok("Student " + student.getFirstName()  + " was deleted from group " + group.getName()
                            + " successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/add-subject")
    public ResponseEntity<?> addSubjectToGroup(@RequestBody GroupFormRequest request){
        Subject subject = subjectService.getSubjectFromBd(request.getSubjectId());
        Group group = groupService.get(request.getGroupId());

        if (subject != null && group != null){
            group.getSubjects().add(subject);
            groupService.update(group, request.getGroupId());
            return ResponseEntity.ok("Subject " + subject.getName()  + " was added to group " + group.getName()
                    + " successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/remove-subject")
    public ResponseEntity<?> removeSubjectFromGroup(@RequestParam Long groupId,
                                               @RequestParam Long subjectId){
        Subject subject = subjectService.getSubjectFromBd(subjectId);
        Group group = groupService.get(groupId);

        if (subject != null && group != null){
            group.getSubjects().clear();
            groupService.update(group, groupId);
            return ResponseEntity.ok("Subject " + subject.getName()  + " was deleted from group " + group.getName()
                    + " successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
