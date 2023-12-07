package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Services.DebtService;
import com.example.studentsretake.Services.PerformanceService;
import com.example.studentsretake.Services.StudentService;
import com.example.studentsretake.Services.impl.GroupService;
import com.example.studentsretake.Services.impl.UserService;
import com.example.studentsretake.dao.request.StudentFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin/")
@RestController
@RequiredArgsConstructor
public class AdminUserController {

    private final StudentService studentService;
    private final GroupService groupService;
    private final UserService userService;

    @DeleteMapping("/user/delete")
    public void deleteUser(@RequestBody StudentFormRequest studentFormRequest){
//        userService.delete(studentFormRequest.getID());
    }

    @PutMapping("/student/set-info")
    public ResponseEntity<?> setStudentData(@RequestBody StudentFormRequest studentData){
        System.out.printf("------ %d -------", studentData.getID());
        Student student = studentService.getById(studentData.getID());
        student.setGroup(groupService.getByName(studentData.getGroupName()));
        student.setFirstName(studentData.getFirstName());
        student.setLastName(studentData.getLastName());
        student.setCode(studentData.getCode());
        student.setTerm(studentData.getTerm());
        studentService.update(studentData.getID(), student);
        return ResponseEntity.ok().build();
    }
}
