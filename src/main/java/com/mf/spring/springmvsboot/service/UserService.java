package com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.model.User;

import java.util.List;

public interface UserService{

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUser(Long id);

    void updateUser(User updateUser);
}
