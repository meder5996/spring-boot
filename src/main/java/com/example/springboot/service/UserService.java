package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    String delete(Long id);

    User update(Long id, User newUser);
}
