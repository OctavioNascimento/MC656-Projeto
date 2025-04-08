package com.bicicletariocentral.backend.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String username;
    private String firstName;
    private Date birthDate;
    private boolean active;
}