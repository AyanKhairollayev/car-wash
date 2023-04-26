package com.example.carwash.controller;

import com.example.carwash.dto.UserDto;
import com.example.carwash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @Validated UserDto userDto) {
        if(userService.findByUsername(userDto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        userService.registration(userDto);
        return ResponseEntity.ok("User successfully registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }
}
