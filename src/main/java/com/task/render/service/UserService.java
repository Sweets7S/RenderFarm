package com.task.render.service;

import com.task.render.entity.User;
import com.task.render.repository.UserRepo;
import org.springframework.stereotype.Service;

// Sweets
@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User create(User user) {
        return userRepo.save(user);
    }
}
