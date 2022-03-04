package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.ItemType;
import org.bson.types.ObjectId;

import java.util.List;

public interface ItemTypesService {

    List<ItemType> findAll();

    ItemType findItemTypeById(ObjectId id);

    List<ItemType> findItemTypesByType(String type);

    ItemType saveOrUpdateItemType(ItemType itemType);

    void deleteItemTypeById(ObjectId id);

}
