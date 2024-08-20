package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.repositories.ItemsRepository;
import com.kfir.inventory_be.services.ItemTypesService;
import com.kfir.inventory_be.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository repo;

    @Autowired
    private ItemTypesService itService;


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
    public List<Item> getAllItemsByType(){
        List<ItemType> basicTypes = itService.findAllByBasic(true);

        List<Item> foundItems = new ArrayList<>();

        for(ItemType type: basicTypes){
            foundItems.addAll(repo.getAllItemsByType(type));
        }

        return foundItems;
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
    public List<Item> getAllByIsInStock(boolean isInStock) {
        return repo.getAllByIsInStock(isInStock);
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

    public List<Item> findAllByExpirationDateIsBetween(LocalDate today, LocalDate todayPlus1Month){
        return repo.findAllByExpirationDateIsBetween(today,todayPlus1Month);
    }

    @Override
    public Map<String,List<Item>> getAllItemsInCategories() {

        Map<String ,List<Item>> categorizedItems = new HashMap<>();

        List<Item> allItems = findAll();

        allItems.stream().forEach(item -> {

            String itemDisplayName = item.getType().getDisplayName();

            if(item.getType().getTypeId().contains("-")){
                return;
            }

            if (categorizedItems.containsKey(item.getType().getDisplayName())) {
                categorizedItems.get(itemDisplayName).add(item);
            } else {
                categorizedItems.put(itemDisplayName,new ArrayList<>(){{add(item);}});
            }
        });

        return categorizedItems;
    }
}
