package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Item;

import java.util.List;
import java.util.UUID;

public interface ItemsService {

    List<Item> findAll();

    Item findItemById(UUID id);

    Item saveOrUpdateItem(Item item);

    void deleteItemById(UUID id);

    List<Item> getAllByInStock(boolean isInStock);

    List<Item> getAllByLinkedPersonIsNotNull();
}
