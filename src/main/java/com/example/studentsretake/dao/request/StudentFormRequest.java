package com.example.studentsretake.dao.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentFormRequest {
    private Long ID;
    private String firstName;
    private String lastName;
    private int term;
    private String code;
    private String groupName;
}
