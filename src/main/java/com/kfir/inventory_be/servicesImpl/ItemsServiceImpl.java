package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
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
    public List<Item> findItemsByLinkedPerson(ObjectId id) {
        return repo.findItemsByLinkedPerson(id);
    }

    @Override
    public Item findItemByTypeAndSerialNumber(ItemType type, int serialNumber) {
        return repo.findItemByTypeAndSerialNumber(type,serialNumber);
    }

    @Override
    public List<Item> findItemsByType(ItemType type) {
        return repo.findItemsByType(type);
    }

    @Override
    public List<Item> findItemsByInStock(boolean isInStock) {
        return repo.findItemsByInStock(isInStock);
    }

    @Override
    public List<Item> findItemsBySerialNumber(int serialNumber) {
        return repo.findItemsBySerialNumber(serialNumber);
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
