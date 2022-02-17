package com.mf.spring.springmvsboot.database;

import com.mf.spring.springmvsboot.model.Role;
import com.mf.spring.springmvsboot.model.User;
import com.mf.spring.springmvsboot.service.RoleService;
import com.mf.spring.springmvsboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataBaseInit {

    private final UserService userService;
    private final RoleService roleService;
    Set<Role> defaultRoles;

    @Autowired
    public DataBaseInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct(){
        addRolesToDB();
        addUsersToDB();
    }

    private void addRolesToDB(){
        List<Role> roleList = null;
        try {
            roleList = roleService.getAllRoles();
        } catch (Exception ignore) {
        }

        if (roleList == null || roleList.isEmpty()) {
            for (StandartRoles role : StandartRoles.values()) {
                roleService.saveRole(new Role(role));
            }
        }
    }

    public void addUsersToDB(){

        Role roleUser = roleService.getRoleByName(StandartRoles.ROLE_USER.name());
        Role roleAdmin = roleService.getRoleByName(StandartRoles.ROLE_ADMIN.name());

        userService.saveUsers(
                new User("Admin", "admin", "admin",
                        "+79956810991", "admin@mail.ru")
                        .addRolesToUser(roleUser, roleAdmin),

                new User("User", "user", "user",
                        "+79321815512", "user@mail.ru")
                        .addRoleToUser(roleUser));
    }

    @Bean
    public Set<Role> getDefaultRoles() {
        if (defaultRoles == null || defaultRoles.isEmpty()) {
            defaultRoles = new HashSet<>(roleService.getAllRoles());
        }
        return defaultRoles;
    }
}