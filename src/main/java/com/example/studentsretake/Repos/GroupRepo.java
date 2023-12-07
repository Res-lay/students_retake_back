package com.example.studentsretake.Repos;

import com.example.studentsretake.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
