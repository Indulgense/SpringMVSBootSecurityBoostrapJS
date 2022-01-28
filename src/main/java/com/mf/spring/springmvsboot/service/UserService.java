package com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void addUser(User user);
    void deleteById(Long id);
    User getUserById(Long id);
    void updateUser(User user);
    User getByName(String name);
}
