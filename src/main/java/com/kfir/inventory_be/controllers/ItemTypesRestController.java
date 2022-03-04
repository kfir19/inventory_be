package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.ItemTypeDTO;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.services.ItemTypesService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item_types")
public class ItemTypesRestController {

    @Autowired
    private ItemTypesService itemTypesService;


    @GetMapping(value = "/")
    public List<ItemTypeDTO> getAllItemTypes() {
        return ObjectMapperUtils.mapAll(itemTypesService.findAll(), ItemTypeDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public ItemTypeDTO getItemTypeById(@PathVariable("id") ObjectId itemTypeId) {
        return ObjectMapperUtils.map(itemTypesService.findItemTypeById(itemTypeId), ItemTypeDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ItemTypeDTO> saveOrUpdateItemType(@RequestBody ItemTypeDTO itemTypeDTO) {
        itemTypesService.saveOrUpdateItemType(ObjectMapperUtils.map(itemTypeDTO, ItemType.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{itemTypeId}")
    public ResponseEntity<ItemTypeDTO> deleteItemTypeById(@PathVariable("itemTypeId") ObjectId itemTypeId) {
        itemTypesService.deleteItemTypeById(itemTypesService.findItemTypeById(itemTypeId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
