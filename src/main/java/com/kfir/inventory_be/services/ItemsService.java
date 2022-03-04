package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Item;
import org.bson.types.ObjectId;

import java.util.List;

public interface ItemsService {

    List<Item> findAll();

    Item findItemById(ObjectId id);

    Item saveOrUpdateItem(Item item);

    void deleteItemById(ObjectId id);
}
