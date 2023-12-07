package com.example.studentsretake.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupFormRequest {
    private Long studentId;
    private Long groupId;
    private Long subjectId;
    private String groupName;
}
