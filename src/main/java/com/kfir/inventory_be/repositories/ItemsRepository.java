package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ItemsRepository extends MongoRepository<Item, UUID> {

    List<Item> findAll();

    Iterable<Item> findAllById(Iterable<UUID> ids);

    List<Item> getAllItemsByType(ItemType type);

    Item findItemById(UUID id);

    Item save(Item item);

    void deleteItemById(UUID id);

    List<Item> getAllByIsInStock(boolean isInStock);

    List<Item> getAllByLinkedPersonIsNotNull();

    List<Item> findAllByExpirationDateIsBefore(LocalDate today);

    List<Item> findAllByExpirationDateIsBetween(LocalDate today, LocalDate todayPlus1Month);
    @Override
    <S extends Item> List<S> saveAll(Iterable<S> entities);
}
