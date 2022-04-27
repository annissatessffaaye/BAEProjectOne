
package com.qa.baeprojectone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/getById/{id}") // localhost:11000/getById/id
    public User getById(@PathVariable long id) {
        return service.getById(id);
    }

    // @GetMapping("/getAll") // localhost:11000/getAll

    // Post

    // Put/Patch

    // Delete

}
