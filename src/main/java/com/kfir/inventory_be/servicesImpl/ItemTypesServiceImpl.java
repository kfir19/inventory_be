package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.repositories.ItemTypesRepository;
import com.kfir.inventory_be.services.ItemTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemTypesServiceImpl implements ItemTypesService {

    @Autowired
    private ItemTypesRepository repo;

    @Override
    public List<ItemType> findAll() {
        return repo.findAll();
    }

    @Override
    public ItemType findItemTypeById(UUID id) {
        return repo.findItemTypeById(id);
    }

    @Override
    public ItemType saveOrUpdateItemType(ItemType itemType) {
        return repo.save(itemType);
    }

    @Override
    public void deleteItemTypeById(UUID id) {
        repo.deleteItemTypeById(id);
    }

    @Override
    public List<ItemType> saveAll(List<ItemType> itemTypes) {
        return repo.saveAll(itemTypes);
    }

    public List<ItemType> findAllByBasic(boolean basic) {
        return repo.findAllByBasic(basic);
    }
}
