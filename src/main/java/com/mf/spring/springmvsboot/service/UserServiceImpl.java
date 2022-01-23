package com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.dao.UserDAO;
import com.mf.spring.springmvsboot.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.createUser(user);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        if (updatedUser.getPassword() != "")
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
