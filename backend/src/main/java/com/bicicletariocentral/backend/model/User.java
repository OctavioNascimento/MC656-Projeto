package com.bicicletariocentral.backend.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private Date birthDate;
    
    @Column(nullable = false)
    private boolean active;
}