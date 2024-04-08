package com.example.userapp.controller;


import com.example.userapp.model.User;
import com.example.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("/{username}")
    public User getDetails(@PathVariable String username) {
        return userService.getDetails(username);
    }

    @PutMapping("/{id}")
    public User updateDetails(@PathVariable Long id, @RequestBody User user) {
        // Ensure user id in URL matches user id in request body
        if (id.equals(user.getId())) {
            return userService.updateDetails(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
