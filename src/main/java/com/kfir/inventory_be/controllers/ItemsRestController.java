package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.ItemDTO;
import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.services.ItemsService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsRestController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping(value = "/")
    public List<ItemDTO> getAllItems() {
        return ObjectMapperUtils.mapAll(itemsService.findAll(), ItemDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public ItemDTO getItemById(@PathVariable("id") ObjectId itemId) {
        return ObjectMapperUtils.map(itemsService.findItemById(itemId), ItemDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ItemDTO> saveOrUpdateItem(@RequestBody ItemDTO itemDTO) {
        itemsService.saveOrUpdateItem(ObjectMapperUtils.map(itemDTO, Item.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{itemId}")
    public ResponseEntity<ItemDTO> deleteItemById(@PathVariable("itemId") ObjectId itemId) {
        itemsService.deleteItemById(itemsService.findItemById(itemId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
