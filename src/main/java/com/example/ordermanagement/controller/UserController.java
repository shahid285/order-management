package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Users;
import com.example.ordermanagement.services.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-mgmt")
public class UserController {

    private final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUsers() {
        return userService.getUsers().get(0).getUsername()+": - :"+userService.getUsers().get(0).getEmailId();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody Users user) {
        userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public void createUser(@PathVariable Long id, @RequestBody Users user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PatchMapping("/users/{id}") //Partial Update
    public void patchUser(@PathVariable Long id,@RequestBody Users user) {
        userService.updateUser(id, user);
    }
}
