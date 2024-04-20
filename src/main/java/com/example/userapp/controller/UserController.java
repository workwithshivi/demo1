package com.example.userapp.controller;


import com.example.userapp.dto.User;
import com.example.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("/user/{username}")
    public User getDetails(@PathVariable String username) {
        return userService.getDetails(username);
    }

    @PutMapping("/user/{id}")
    public User updateDetails(@PathVariable Long id, @RequestBody User user) {
        // Ensure user id in URL matches user id in request body
        if (id.equals(user.getId())) {
            return userService.updateDetails(user);
        }
        return null;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
