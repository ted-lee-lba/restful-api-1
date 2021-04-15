package com.m2u.interview.domain.service;

import com.m2u.interview.db.entity.User;
import com.m2u.interview.db.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javassist.NotFoundException;

public class UserService {
    @Autowired
    private UserRepository _userRepository;

    public boolean isAuthUser(String userName, String password) throws NotFoundException {
        User user = _userRepository.findByUserName(userName).orElseThrow(() -> new NotFoundException("User not found"));
        if (user.getPassword().equals(password)) {
            
        }
        return true;
    }
}
