package com.example.studentsretake.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "student_groups")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Integer term;
    private String name;
    @OneToMany
    @JsonIgnore
    private List<Student> students;
    @OneToMany
    private List<Subject> subjects;
}
