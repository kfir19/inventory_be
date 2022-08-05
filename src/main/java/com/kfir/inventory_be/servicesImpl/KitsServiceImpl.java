package com.kfir.inventory_be.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KitsServiceImpl implements KitsService {

    @Autowired
    private KitsRepository repo;

    @Override
    public List<Kit> findAll() {
        return repo.findAll();
    }

    @Override
    public Kit findKitById(UUID id) {
        return repo.findKitById(id);
    }

    @Override
    public Kit save(Kit kit) {
        return repo.save(kit);
    }

    @Override
    public void deleteKitById(UUID id) {
        repo.deleteKitById(id);
    }
}
