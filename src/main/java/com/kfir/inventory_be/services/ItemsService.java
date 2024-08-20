package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ItemsService {

    List<Item> findAll();

    Iterable<Item> findAllById(Iterable<UUID> ids);

    List<Item> getAllItemsByType();

    Item findItemById(UUID id);

    Item saveOrUpdateItem(Item item);

    void deleteItemById(UUID id);

    List<Item> getAllByIsInStock(boolean isInStock);

    List<Item> getAllByLinkedPersonIsNotNull();

    List<Item> saveAll(List<Item> items);

    List<Item> findAllByExpirationDateIsBefore(LocalDate today);

    List<Item> findAllByExpirationDateIsBetween(LocalDate today, LocalDate todayPlus1Month);

    Map<String,List<Item>> getAllItemsInCategories();
}
