package com.example.userapp.service;


import com.example.userapp.model.User;
import com.example.userapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        // Implement password policy here
        // For example: check password strength, length, etc.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        // Implement login functionality here
        // Check username and password against database
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User getDetails(String username) {
        // Implement fetching user details
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateDetails(User user) {
        // Implement updating user details
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        // Implement deleting user
        userRepository.deleteById(id);
    }
}
