package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.Role;
import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Repos.RoleRepo;
import com.example.studentsretake.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class RoleController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @RequestMapping(value = "/public/setRole", method = RequestMethod.PUT)
    public ResponseEntity<String> setRole(@RequestParam String role, @RequestParam Long id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        if (role.equals("ROLE_ADMIN")){
            Set<Role> roles = user.getRoles();
            roles.add(roleRepo.findById(3L).orElseThrow());
            user.setRoles(roles);
        } else if (role.equals("ROLE_STUDENT")) {
            Set<Role> roles = user.getRoles();
            roles.add(roleRepo.findById(1L).orElseThrow());
            user.setRoles(roles);
        } else if (role.equals("ROLE_TEACHER")) {
            Set<Role> roles = user.getRoles();
            roles.add(roleRepo.findById(2L).orElseThrow());
            user.setRoles(roles);
        }

        userRepo.save(user);
        return ResponseEntity.ok("Roles successfully updated");
    }
    @RequestMapping(value = "/public/removeRole")
    public ResponseEntity<String> deleteRole(@RequestParam Long id, @RequestParam String role){
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        if (role.equals("ROLE_ADMIN")){
            Set<Role> roles = user.getRoles();
            roles.remove(roleRepo.findById(3L).orElseThrow());
            user.setRoles(roles);
        } else if (role.equals("ROLE_STUDENT")) {
            Set<Role> roles = user.getRoles();
            roles.remove(roleRepo.findById(1L).orElseThrow());
            user.setRoles(roles);
        } else if (role.equals("ROLE_TEACHER")) {
            Set<Role> roles = user.getRoles();
            roles.remove(roleRepo.findById(2L).orElseThrow());
            user.setRoles(roles);
        }

        userRepo.save(user);
        return ResponseEntity.ok("Roles successfully updated");
    }

}
