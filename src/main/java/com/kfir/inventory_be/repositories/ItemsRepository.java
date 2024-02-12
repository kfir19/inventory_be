package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ItemsRepository extends MongoRepository<Item, UUID> {

    List<Item> findAll();

    Iterable<Item> findAllById(Iterable<UUID> ids);

    Item findItemById(UUID id);

    Item save(Item item);

    void deleteItemById(UUID id);

    List<Item> getAllByInStock(boolean isInStock);

    List<Item> getAllByLinkedPersonIsNotNull();

    List<Item> findAllByExpirationDateIsBefore(LocalDate today);
    @Override
    <S extends Item> List<S> saveAll(Iterable<S> entities);
}
