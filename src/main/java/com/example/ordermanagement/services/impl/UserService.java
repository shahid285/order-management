package com.example.ordermanagement.services.impl;

import com.example.ordermanagement.exception.OrderException;
import com.example.ordermanagement.model.Users;
import com.example.ordermanagement.repo.UsersRepository;
import com.example.ordermanagement.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void createUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void updateUser(Long id, Users updatedUser) {

        usersRepository.findById(id).map(user -> {
            if (!user.getUsername().equals(updatedUser.getUsername())) {
                user.setUsername(updatedUser.getUsername());

            }
            return usersRepository.save(user);
        }).orElseThrow(() -> new OrderException(" : "+id));

    }
    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
