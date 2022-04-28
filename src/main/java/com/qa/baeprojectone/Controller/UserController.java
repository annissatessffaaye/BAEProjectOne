package com.qa.baeprojectone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baeprojectone.domain.User;
import com.qa.baeprojectone.service.UserService;

@RestController
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Get by ID (get one User)
    @GetMapping("/getById/{id}") // localhost:12000/getById/id
    public User getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll") // localhost:12000/getAll
    public List<User> getAll() {
        return service.getAll();
    }

    // Post
    @PostMapping("/create") // localhost:12000/create
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    // Put
    @PutMapping("/update/{id}") // localhost:12000/update/id
    public User update(@PathVariable long id, @RequestBody User user) {
        return service.update(id, user);
    }

    // Delete

}