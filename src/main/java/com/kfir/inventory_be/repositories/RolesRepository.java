package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface RolesRepository extends MongoRepository<Role, UUID> {

    List<Role> findAll();

    Role findRoleById(UUID id);

    Role save(Role role);

    void deleteRoleById(UUID id);

}
