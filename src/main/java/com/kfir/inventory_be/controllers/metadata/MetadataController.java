package com.kfir.inventory_be.controllers.metadata;

import com.kfir.inventory_be.dto.metadata.*;
import com.kfir.inventory_be.models.metadata.*;
import com.kfir.inventory_be.services.metadata.*;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/system_metadata")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class MetadataController {

    @Autowired
    private SystemMetadataService systemMetadataService;
    @Autowired
    private ItemsOutMetadataService itemsOutMetadataService;
    @Autowired
    private LoanItemsMetadataService loanItemsMetadataService;
    @Autowired
    private ManageItemsMetadataService manageItemsMetadataService;
    @Autowired
    private ManagePeopleMetadataService managePeopleMetadataService;


    /*--------------- ITEMS OUT --------------------*/

    @GetMapping(value = "/items_out/byId/{id}")
    public ItemsOutMetadataDTO getItemOutMetadataById(@PathVariable("id") UUID id) {
        return ObjectMapperUtils.map(itemsOutMetadataService.findItemsOutMetadataById(id), ItemsOutMetadataDTO.class);
    }

    @PostMapping(value = "/items_out/save")
    public ResponseEntity<ItemsOutMetadataDTO> saveOrUpdateItem(@RequestBody ItemsOutMetadataDTO itemsOutMetadataDTO) {
        itemsOutMetadataService.save(ObjectMapperUtils.map(itemsOutMetadataDTO, ItemsOutMetadata.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*------------- LOAN ITEMS -------------------*/

    @GetMapping(value = "/loan_items/byId/{id}")
    public LoanItemsMetadataDTO getLoanItemsMetadataById(@PathVariable("id") UUID id) {
        return ObjectMapperUtils.map(loanItemsMetadataService.findLoanItemsMetadataById(id), LoanItemsMetadataDTO.class);
    }

    @PostMapping(value = "/loan_items/save")
    public ResponseEntity<LoanItemsMetadataDTO> saveOrUpdateItem(@RequestBody LoanItemsMetadataDTO loanItemsMetadataDTO) {
        loanItemsMetadataService.save(ObjectMapperUtils.map(loanItemsMetadataDTO, LoanItemsMetadata.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*---------------- MANAGE ITEMS ----------------*/

    @GetMapping(value = "/manage_items/byId/{id}")
    public ManageItemsMetadataDTO getManageItemsMetadataById(@PathVariable("id") UUID id) {
        return ObjectMapperUtils.map(manageItemsMetadataService.findManageItemsMetadataById(id), ManageItemsMetadataDTO.class);
    }

    @PostMapping(value = "/manage_items/save")
    public ResponseEntity<ManageItemsMetadataDTO> saveOrUpdateItem(@RequestBody ManageItemsMetadataDTO manageItemsMetadataDTO) {
        manageItemsMetadataService.save(ObjectMapperUtils.map(manageItemsMetadataDTO, ManageItemsMetadata.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*---------------- MANAGE PEOPLE ----------------*/

    @GetMapping(value = "/manage_people/byId/{id}")
    public ManagePeopleMetadataDTO getManagePeopleMetadataById(@PathVariable("id") UUID id) {
        return ObjectMapperUtils.map(managePeopleMetadataService.findManagePeopleMetadataById(id), ManagePeopleMetadataDTO.class);
    }

    @PostMapping(value = "/manage_people/save")
    public ResponseEntity<ManagePeopleMetadataDTO> saveOrUpdateItem(@RequestBody ManagePeopleMetadataDTO managePeopleMetadataDTO) {
        managePeopleMetadataService.save(ObjectMapperUtils.map(managePeopleMetadataDTO, ManagePeopleMetadata.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*----------------- SYSTEM -------------------------*/

    @GetMapping(value = "/system/byId/{id}")
    public SystemMetadataDTO getSystemMetadataById(@PathVariable("id") UUID id) {
        return ObjectMapperUtils.map(systemMetadataService.findSystemMetadataById(id), SystemMetadataDTO.class);
    }

    @PostMapping(value = "/system/save")
    public ResponseEntity<SystemMetadataDTO> saveOrUpdateItem(@RequestBody SystemMetadataDTO systemMetadataDTO) {
        systemMetadataService.save(ObjectMapperUtils.map(systemMetadataDTO, SystemMetadata.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
