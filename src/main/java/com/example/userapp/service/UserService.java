package com.example.userapp.service;


import com.example.userapp.dto.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User getDetails(String username);
    User updateDetails(User user);
    void deleteUser(Long id);
}
