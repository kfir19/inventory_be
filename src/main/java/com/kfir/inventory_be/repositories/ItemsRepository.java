package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemsRepository extends MongoRepository<Item, ObjectId> {

    List<Item> findAll();

    Item findItemById(ObjectId id);

    Item save(Item item);

    void deleteItemById(ObjectId id);
}
