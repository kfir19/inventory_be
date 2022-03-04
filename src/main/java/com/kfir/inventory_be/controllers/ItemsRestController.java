package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.ItemDTO;
import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
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

    @GetMapping(value = "/byLinkedPerson/{linkedPersonId}")
    public List<ItemDTO> getItemsByLinkedPerson(@PathVariable("linkedPersonId") ObjectId linkedPersonId) {
        return ObjectMapperUtils.mapAll(itemsService.findItemsByLinkedPerson(linkedPersonId), ItemDTO.class);
    }

    @GetMapping(value = "/byTypeAndSerialNumber/{type}/{serialNumber}")
    public ItemDTO getItemByTypeAndSerialNumber(@PathVariable("type") ItemType type, @PathVariable("serialNumber") int serialNumber) {
        return ObjectMapperUtils.map(itemsService.findItemByTypeAndSerialNumber(type, serialNumber), ItemDTO.class);
    }

    @GetMapping(value = "/byType/{type}")
    public List<ItemDTO> getItemsByType(@PathVariable("type") ItemType type) {
        return ObjectMapperUtils.mapAll(itemsService.findItemsByType(type), ItemDTO.class);
    }

    @GetMapping(value = "/byInStock/{isInStock}")
    public List<ItemDTO> getItemsByInStock(@PathVariable("isInStock") boolean isInStock) {
        return ObjectMapperUtils.mapAll(itemsService.findItemsByInStock(isInStock), ItemDTO.class);
    }

    @GetMapping(value = "/bySerialNumber/{serialNumber}")
    public List<ItemDTO> getItemsBySerialNumber(@PathVariable("serialNumber") int serialNumber) {
        return ObjectMapperUtils.mapAll(itemsService.findItemsBySerialNumber(serialNumber), ItemDTO.class);
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
