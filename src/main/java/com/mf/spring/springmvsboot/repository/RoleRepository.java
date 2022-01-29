package com.mf.spring.springmvsboot.repository;

import com.mf.spring.springmvsboot.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long> {
    Set<Role> findAll();
    Role findRoleByRole(String role);
    Role findRoleById(Long id);
}
