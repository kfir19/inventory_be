package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.ItemType;

import java.util.List;
import java.util.UUID;

public interface ItemTypesService {

    List<ItemType> findAll();

    ItemType findItemTypeById(UUID id);

    ItemType saveOrUpdateItemType(ItemType itemType);

    void deleteItemTypeById(UUID id);

    List<ItemType> saveAll(List<ItemType> itemTypes);

}
