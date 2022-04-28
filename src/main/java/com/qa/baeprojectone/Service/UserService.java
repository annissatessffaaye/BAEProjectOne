package com.qa.baeprojectone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baeprojectone.domain.User;
import com.qa.baeprojectone.repo.UserRepo;

@Service
public class UserService {

    private UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    // Get By ID (get one User)
    public User getById(long id) {
        return repo.findById(id).get(); // .get() will either get the User (if exists) OR throw NoSuchElementException
    }

    // Get ALL users
    public List<User> getAll() {
        return repo.findAll();
    }

    // Create a new user
    public User create(User user) {
        return repo.saveAndFlush(user);
    }

}