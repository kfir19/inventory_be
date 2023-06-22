package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.ItemType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ItemTypesRepository extends MongoRepository<ItemType, UUID> {

    List<ItemType> findAll();

    ItemType findItemTypeById(UUID id);

    ItemType save(ItemType itemType);

    @Override
    <S extends ItemType> List<S> saveAll(Iterable<S> entities);

    void deleteItemTypeById(UUID id);
}
