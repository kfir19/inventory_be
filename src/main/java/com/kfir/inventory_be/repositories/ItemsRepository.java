package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemsRepository extends MongoRepository<Item, ObjectId> {

    List<Item> findAll();

    Item findItemById(ObjectId id);

    List<Item> findItemsByLinkedPerson(ObjectId id);

    Item findItemByTypeAndSerialNumber(ItemType type, int serialNumber);

    List<Item> findItemsByType(ItemType type);

    List<Item> findItemsByInStock(boolean isInStock);

    List<Item> findItemsBySerialNumber(int serialNumber);

    Item save(Item item);

    void deleteItemById(ObjectId id);
}
