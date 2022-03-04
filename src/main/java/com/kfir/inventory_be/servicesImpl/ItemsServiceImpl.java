package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.repositories.ItemsRepository;
import com.kfir.inventory_be.services.ItemsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository repo;

    @Override
    public List<Item> findAll() {
        return repo.findAll();
    }

    @Override
    public Item findItemById(ObjectId id) {
        return repo.findItemById(id);
    }

    @Override
    public Item saveOrUpdateItem(Item item) {
        return repo.save(item);
    }

    @Override
    public void deleteItemById(ObjectId id) {
        repo.deleteItemById(id);
    }
}
