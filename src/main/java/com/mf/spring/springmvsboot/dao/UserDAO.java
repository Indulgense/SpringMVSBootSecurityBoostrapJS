package com.mf.spring.springmvsboot.dao;

import com.mf.spring.springmvsboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Long> {
}
