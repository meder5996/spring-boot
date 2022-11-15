package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/registration")
    public String save(@RequestBody User user){
        userService.save(user);
        return "Successfully saved!";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }
}
