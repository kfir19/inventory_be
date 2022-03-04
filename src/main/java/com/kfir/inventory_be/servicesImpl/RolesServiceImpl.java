package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Role;
import com.kfir.inventory_be.repositories.RolesRepository;
import com.kfir.inventory_be.services.RolesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository repo;

    @Override
    public List<Role> findAll() {
        return repo.findAll();
    }

    @Override
    public Role findRoleById(ObjectId id) {
        return repo.findRoleById(id);
    }

    @Override
    public Role saveOrUpdateRole(Role role) {
        return repo.save(role);
    }

    @Override
    public void deleteRoleById(ObjectId id) {
        repo.deleteRoleById(id);
    }
}
