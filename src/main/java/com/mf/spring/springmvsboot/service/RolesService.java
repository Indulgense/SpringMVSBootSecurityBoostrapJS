package com.mf.spring.springmvsboot.service;


import com.mf.spring.springmvsboot.model.Roles;

import java.util.HashSet;
import java.util.List;


public interface RolesService {

    List<Roles> getAllRoles();
    Roles getRoleByName(String name);
    HashSet<Roles> getSetOfRoles(String[] roleNames);
}
