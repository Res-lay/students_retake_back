package com.example.studentsretake.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDataRequest {
    private String firstName;
    private String lastName;
    private String groupName;
}
