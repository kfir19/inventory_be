package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Role;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RolesRepository extends MongoRepository<Role, ObjectId> {

    List<Role> findAll();

    Role findRoleById(ObjectId id);

    List<Role> findRolesByKind(String kind);

    Role save(Role role);

    void deleteRoleById(ObjectId id);

}
