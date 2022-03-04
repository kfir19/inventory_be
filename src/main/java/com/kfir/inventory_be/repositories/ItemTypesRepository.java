package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.ItemType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemTypesRepository extends MongoRepository<ItemType, ObjectId> {

    List<ItemType> findAll();

    ItemType findItemTypeById(ObjectId id);

    List<ItemType> findItemTypesByType(String type);

    ItemType save(ItemType itemType);

    void deleteItemTypeById(ObjectId id);
}
