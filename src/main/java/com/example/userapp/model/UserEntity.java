package com.example.userapp.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
@Data
public class UserEntity {
    @Id
    private Long id;
    @NotBlank
    private String username;
    @Min(value = 6)
    @Max(value = 10)
    private String password;
    @Email
    private String email;
    private String address;
    private String role;
    private boolean enabled;
}
