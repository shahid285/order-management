package com.example.ordermanagement.services;

import com.example.ordermanagement.model.Users;

import java.util.List;

public interface IUserService {

    List<Users> getUsers();
    void createUser(Users user);
    void updateUser(Long id, Users user);
    void deleteUser(Long id);
}
