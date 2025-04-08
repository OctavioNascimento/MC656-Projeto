package com.bicicletariocentral.backend.controllers;

import com.bicicletariocentral.backend.dto.*;
import com.bicicletariocentral.backend.services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/create/{email}")
    public ResponseEntity<?> createUser(@PathVariable String email) {
        if (userService.emailAlreadyUsed(email)) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Já existe um usuário cadastrado com o e-mail: " + email);
        }

        if (!email.endsWith("@dac.unicamp.br")){
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Não é permitido o domínio do e-mail informado: " + email);
        }
        
        try {
            UserDTO createdUser = userService.createUserWithEmail(email);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Falha ao criar usuário: " + e.getMessage());
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}