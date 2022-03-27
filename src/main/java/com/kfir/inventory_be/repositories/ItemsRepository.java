package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.UUID;

public interface ItemsRepository extends MongoRepository<Item, UUID> {

    List<Item> findAll();

    Item findItemById(UUID id);

    Item save(Item item);

    void deleteItemById(UUID id);

    List<Item> getAllByInStock(boolean isInStock);

    List<Item> getAllByLinkedPersonIsNotNull();
}
