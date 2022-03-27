package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.repositories.ItemsRepository;
import com.kfir.inventory_be.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository repo;

    @Override
    public List<Item> findAll() {
        return repo.findAll();
    }

    @Override
    public Item findItemById(UUID id) {
        return repo.findItemById(id);
    }

    @Override
    public Item saveOrUpdateItem(Item item) {
        return repo.save(item);
    }

    @Override
    public void deleteItemById(UUID id) {
        repo.deleteItemById(id);
    }

    @Override
    public List<Item> getAllByInStock(boolean isInStock) {
        return repo.getAllByInStock(isInStock);
    }

    @Override
    public List<Item> getAllByLinkedPersonIsNotNull() {
        return repo.getAllByLinkedPersonIsNotNull();
    }
}
