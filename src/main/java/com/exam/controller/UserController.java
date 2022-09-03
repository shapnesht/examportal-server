package com.exam.controller;


import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/test")
    public String test() {
        return "Welcome to backend API of Quizzy";
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role("NORMAL", 1L);

        user.setPassword(encoder.encode(user.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user, roles);
    }

    @GetMapping("/{username}")
    public User returnUserByUserName(@PathVariable("username") String username) throws Exception {
        return userService.getUserByUsername(username);
    }

    @DeleteMapping("/{username}")
    public void deleteUserByUserName(@PathVariable("username") String username) throws Exception {
        userService.deleteUserByUsername(username);
    }

    @PatchMapping("/{username}")
    public User deleteUserByUserName(@PathVariable("username") String username, @RequestBody User user) throws Exception {
        return userService.updateUserByUsername(username, user);
    }

}
