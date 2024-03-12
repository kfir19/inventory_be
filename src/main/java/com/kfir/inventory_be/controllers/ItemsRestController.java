package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.models.dto.ItemDTO;
import com.kfir.inventory_be.services.ItemsService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class ItemsRestController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping(value = "/")
    public List<ItemDTO> getAllItems() {
        return ObjectMapperUtils.mapAll(itemsService.findAll(), ItemDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public ItemDTO getItemById(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.map(itemsService.findItemById(itemId), ItemDTO.class);
    }

    @GetMapping(value = "/byBasicType")
    public List<ItemDTO> getAllItemsByType() {
        return ObjectMapperUtils.mapAll(itemsService.getAllItemsByType(), ItemDTO.class);
    }

    @GetMapping(value = "/getAllItemsInCategories")
    public Map<String, List<Item>> getAllItemsInCategories() {
        return ObjectMapperUtils.map(itemsService.getAllItemsInCategories(), Map.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ItemDTO> saveOrUpdateItem(@RequestBody ItemDTO itemDTO) {
        try {
            itemsService.saveOrUpdateItem(ObjectMapperUtils.map(itemDTO, Item.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<List<ItemDTO>> saveOrUpdateItem(@RequestBody List<ItemDTO> itemDTOs) {
        try {
            itemsService.saveAll(ObjectMapperUtils.mapAll(itemDTOs, Item.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{itemId}")
    public ResponseEntity<ItemDTO> deleteItemById(@PathVariable("itemId") UUID itemId) {
        try {
            itemsService.deleteItemById(itemId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/byInStock/{isInStock}")
    public List<ItemDTO> getAllItemsByInStock(@PathVariable("isInStock") boolean itemInStock) {
        return ObjectMapperUtils.mapAll(itemsService.getAllByInStock(itemInStock), ItemDTO.class);
    }

    @GetMapping(value = "/byLinkedPersonNotNull")
    public List<ItemDTO> getItemById() {
        return ObjectMapperUtils.mapAll(itemsService.getAllByLinkedPersonIsNotNull(), ItemDTO.class);
    }

    @GetMapping(value = "/expiredItems")
    public List<ItemDTO> getAllExpiredItems() {
        List<Item> expiredItems = itemsService.findAllByExpirationDateIsBefore(LocalDate.now());
        return ObjectMapperUtils.mapAll(expiredItems, ItemDTO.class);
    }
}
