package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Role;
import org.bson.types.ObjectId;

import java.util.List;

public interface RolesService {

    List<Role> findAll();

    Role findRoleById(ObjectId id);

    List<Role> findRolesByKind(String kind);

    Role saveOrUpdateRole(Role role);

    void deleteRoleById(ObjectId id);

}
