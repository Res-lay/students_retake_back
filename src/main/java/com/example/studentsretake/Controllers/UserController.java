package com.example.studentsretake.Controllers;

import com.example.studentsretake.Entities.User;
import com.example.studentsretake.Services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    private static final String UPLOAD_DIRECTORY = "src/main/resources/static/images/";
    private final UserService userService;

    @GetMapping("user-info")
    public ResponseEntity<User> getUser(Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        return ResponseEntity.ok(user);
    }
    @PostMapping("upload-photo")
    public ResponseEntity<?> setPhoto(@RequestBody MultipartFile file, Principal principal) throws IOException {

        if (file.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        User user = userService.getUserByEmail(principal.getName());
        String originalFileName = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/images", originalFileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        user.setPhotoUrl("http://localhost:8080/static/images/" + originalFileName);
        userService.replaceUser(user, user.getId());

        return ResponseEntity.ok().build();
    }
}
