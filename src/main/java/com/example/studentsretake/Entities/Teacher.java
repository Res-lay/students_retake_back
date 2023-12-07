package com.example.studentsretake.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Group> groups;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(
                    name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id", referencedColumnName = "id"))
    private List<Subject> subjects;
}
