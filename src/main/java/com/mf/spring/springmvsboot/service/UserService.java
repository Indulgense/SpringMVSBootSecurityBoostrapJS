package com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.model.User;

import java.util.List;

public interface UserService{

    List<User> getAllUser();
    User getUserById(long id);
    void createUser(User user);
    void updateUser(long id, User updatedUser);
    void deleteUser(long id);
    User getUserByEmail(String email);
}
