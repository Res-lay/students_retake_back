package com.example.studentsretake.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Group group;
    private String code;
    private int term;
    @OneToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Debt> debts;
    @OneToMany
    private List<Performance> performances;
}
