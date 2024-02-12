package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Item;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ItemsService {

    List<Item> findAll();

    Iterable<Item> findAllById(Iterable<UUID> ids);

    Item findItemById(UUID id);

    Item saveOrUpdateItem(Item item);

    void deleteItemById(UUID id);

    List<Item> getAllByInStock(boolean isInStock);

    List<Item> getAllByLinkedPersonIsNotNull();

    List<Item> saveAll(List<Item> items);

    List<Item> findAllByExpirationDateIsBefore(LocalDate today);

    Map<String,List<Item>> getAllItemsInCategories();
}
