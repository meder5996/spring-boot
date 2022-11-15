package com.example.springboot.service.impl;

import com.example.springboot.exception.NotFoundException;
import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import com.example.springboot.repository.RoleRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Override
    public User save(User user) {

        if (user.getName().equals("meder")) {
            user.setRoles(
                    Collections.singleton(
                            new Role("ADMIN"))
            );
        } else {
            if (roleRepository.existsByName("USER")) {
                user.setRoles(
                        Collections.singleton(
                                roleRepository.findByName("USER")
                        )
                );
            } else {
                user.setRoles(
                        Collections.singleton(
                                new Role("USER")
                        )
                );
            }
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->
                new NotFoundException(String.format("User with %d id not found!", id)));
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public User update(Long id, User newUser) {
        return null;
    }
}
