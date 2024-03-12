package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.dto.ItemDTO;
import com.kfir.inventory_be.models.dto.ItemTypeDTO;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.services.ItemTypesService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
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

    @GetMapping(value = "/byBasic/{basic}")
    public List<ItemTypeDTO> getAllItemTypesByBasic(@PathVariable("basic") boolean basic) {
        return ObjectMapperUtils.mapAll(itemTypesService.findAllByBasic(basic), ItemTypeDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public ItemTypeDTO getItemTypeById(@PathVariable("id") UUID itemTypeId) {
        return ObjectMapperUtils.map(itemTypesService.findItemTypeById(itemTypeId), ItemTypeDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ItemTypeDTO> saveOrUpdateItemType(@RequestBody ItemTypeDTO itemTypeDTO) {
        try {
            itemTypesService.saveOrUpdateItemType(ObjectMapperUtils.map(itemTypeDTO, ItemType.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<List<ItemTypeDTO>> saveOrUpdateItem(@RequestBody List<ItemTypeDTO> itemTypeDTO) {
        try {
            itemTypesService.saveAll(ObjectMapperUtils.mapAll(itemTypeDTO, ItemType.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/delete/{itemTypeId}")
    public ResponseEntity<ItemTypeDTO> deleteItemTypeById(@PathVariable("itemTypeId") UUID itemTypeId) {
        try {
            itemTypesService.deleteItemTypeById(itemTypeId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
