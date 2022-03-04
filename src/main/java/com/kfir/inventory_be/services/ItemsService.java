package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import org.bson.types.ObjectId;

import java.util.List;

public interface ItemsService {

    List<Item> findAll();

    Item findItemById(ObjectId id);

    List<Item> findItemsByLinkedPerson(ObjectId id);

    Item findItemByTypeAndSerialNumber(ItemType type, int serialNumber);

    List<Item> findItemsByType(ItemType type);

    List<Item> findItemsByInStock(boolean isInStock);

    List<Item> findItemsBySerialNumber(int serialNumber);

    Item saveOrUpdateItem(Item item);

    void deleteItemById(ObjectId id);
}
