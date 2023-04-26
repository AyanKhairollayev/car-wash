package com.example.carwash.service;

import com.example.carwash.dto.UserDto;
import com.example.carwash.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    User registration(UserDto userDto);
    ResponseEntity<?> login(UserDto userDto);
    Optional<User> findByUsername(String username);
}
