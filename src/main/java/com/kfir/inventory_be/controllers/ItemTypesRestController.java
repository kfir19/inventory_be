package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.dto.ItemTypeDTO;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.services.ItemTypesService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item_types")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class ItemTypesRestController {

    @Autowired
    private ItemTypesService itemTypesService;


    @GetMapping(value = "/")
    public List<ItemTypeDTO> getAllItemTypes() {
        return ObjectMapperUtils.mapAll(itemTypesService.findAll(), ItemTypeDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public ItemTypeDTO getItemTypeById(@PathVariable("id") UUID itemTypeId) {
        return ObjectMapperUtils.map(itemTypesService.findItemTypeById(itemTypeId), ItemTypeDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ItemTypeDTO> saveOrUpdateItemType(@RequestBody ItemTypeDTO itemTypeDTO) {
        itemTypesService.saveOrUpdateItemType(ObjectMapperUtils.map(itemTypeDTO, ItemType.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{itemTypeId}")
    public ResponseEntity<ItemTypeDTO> deleteItemTypeById(@PathVariable("itemTypeId") UUID itemTypeId) {
        itemTypesService.deleteItemTypeById(itemTypesService.findItemTypeById(itemTypeId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
