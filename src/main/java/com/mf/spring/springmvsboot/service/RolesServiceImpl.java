package com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.dao.RolesDAO;
import com.mf.spring.springmvsboot.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class RolesServiceImpl implements RolesService{

    private RolesDAO rolesDAO;

    @Autowired
    public RolesServiceImpl(RolesDAO rolesDAO) {
        this.rolesDAO = rolesDAO;
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesDAO.getAllRoles();
    }

    @Override
    public Roles getRoleByName(String name) {
        return rolesDAO.getRoleByName(name);
    }

    @Override
    public HashSet<Roles> getSetOfRoles(String[] roleNames) {
        return rolesDAO.getSetOfRoles(roleNames);
    }
}
