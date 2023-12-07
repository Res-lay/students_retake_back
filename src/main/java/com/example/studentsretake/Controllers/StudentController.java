package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Group;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Services.DebtService;
import com.example.studentsretake.Services.PerformanceService;
import com.example.studentsretake.Services.StudentService;
import com.example.studentsretake.Services.impl.GroupService;
import com.example.studentsretake.Services.impl.UserService;
import com.example.studentsretake.dao.request.StudentDataRequest;
import com.example.studentsretake.dao.request.StudentFormRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Random;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final UserService userService;
    private final StudentService studentService;
    private final DebtService debtService;
    private final PerformanceService performanceService;
    private final GroupService groupService;


    @GetMapping("/get-info")
    public ResponseEntity<?> getStudent(Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        Student student = studentService.readByUser(user);

        return ResponseEntity.ok(student);
    }
    @GetMapping("/get-debts")
    public ResponseEntity<?> getUserDebts(Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        Student student = studentService.readByUser(user);
        return ResponseEntity.ok(debtService.readStudentDebts(student));
    }
    @GetMapping("/get-performance")
    public ResponseEntity<?> getStudentPerformance(Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        Student student = studentService.readByUser(user);

        return ResponseEntity.ok(performanceService.readByStudent(student));
    }
    @PostMapping("/create/new-student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDataRequest dataForm, Principal principal){
        Group group = groupService.getByName(dataForm.getGroupName());
        Random random = new Random();
        User user = userService.getUserByEmail(principal.getName());
        studentService.delete(studentService.readByUser(user).getId());
        Student student = Student.builder().group(group).user(user).code(String.valueOf(100000 +
                        random.nextInt(900000))).term(group.getTerm()).firstName(dataForm.getFirstName())
                .lastName(dataForm.getLastName()).build();
        performanceService.createPerformance(studentService.create(student)); // Stupid method

        return ResponseEntity.ok().build();
    }

}
