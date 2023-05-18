package com.example.kata312.dao;

import com.example.kata312.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);



}
