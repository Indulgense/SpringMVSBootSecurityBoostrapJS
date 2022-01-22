package com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.dao.UserDAO;
import com.mf.spring.springmvsboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void removeUserById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUser(Long id) {
        User user = null;
        Optional<User> optional = userDAO.findById(id);
        if (optional.isPresent()){
            user = optional.get();
        }
        return user;
    }

    @Override
    public void updateUser(User updateUser) {
        userDAO.save(updateUser);
    }
}
