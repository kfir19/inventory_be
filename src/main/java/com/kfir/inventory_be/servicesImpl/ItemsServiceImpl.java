package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.repositories.ItemsRepository;
import com.kfir.inventory_be.services.ItemsService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository repo;

    @Override
    public List<Item> findAll() {
        return repo.findAll();
    }

    @Override
    public Iterable<Item> findAllById(Iterable<UUID> ids) {
        return repo.findAllById(ids);
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

    @Override
    public List<Item> saveAll(List<Item> items) {
        return repo.saveAll(items);
    }

    @Override
    public List<Item> findAllByExpirationDateIsBefore(LocalDate today){
        return repo.findAllByExpirationDateIsBefore(today);
    }

    @Override
    public Map<String,List<Item>> getAllItemsInCategories() {

        Map<String ,List<Item>> categorizedItems = new HashMap<>();

        List<Item> allItems = findAll();

        allItems.stream().forEach(item -> {

            String itemDisplayName = item.getType().getDisplayName();

            if (categorizedItems.containsKey(item.getType().getDisplayName())) {
                categorizedItems.get(itemDisplayName).add(item);
            } else {
                categorizedItems.put(itemDisplayName,new ArrayList<>(){{add(item);}});
            }
        });

        return categorizedItems;
    }
}
