package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.repositories.ItemTypesRepository;
import com.kfir.inventory_be.services.ItemTypesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypesServiceImpl implements ItemTypesService {

    @Autowired
    private ItemTypesRepository repo;

    @Override
    public List<ItemType> findAll() {
        return repo.findAll();
    }

    @Override
    public ItemType findItemTypeById(ObjectId id) {
        return repo.findItemTypeById(id);
    }

    @Override
    public ItemType saveOrUpdateItemType(ItemType itemType) {
        return repo.save(itemType);
    }

    @Override
    public void deleteItemTypeById(ObjectId id) {
        repo.deleteItemTypeById(id);
    }
}
