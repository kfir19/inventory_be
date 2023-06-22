package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Role;

import java.util.List;
import java.util.UUID;

public interface RolesService {

    List<Role> findAll();

    Role findRoleById(UUID id);

    Role saveOrUpdateRole(Role role);

    void deleteRoleById(UUID id);

    List<Role> saveAll(List<Role> roles);

}
