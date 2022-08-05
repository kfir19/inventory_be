package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Kit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface KitsRepository extends MongoRepository<Kit, UUID> {

    List<Kit> findAll();

    Kit findKitById(UUID id);

    Kit save(Kit kit);

    void deleteKitById(UUID id);
}
