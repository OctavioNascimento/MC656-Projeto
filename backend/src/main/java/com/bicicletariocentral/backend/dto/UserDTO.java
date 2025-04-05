package com.bicicletariocentral.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String username;
    private String firstName;
    private Date birthDate;
    private boolean active;
}