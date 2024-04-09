package com.example.userapp.dto;

import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String role;
}
