package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.Kit;
import com.kfir.inventory_be.models.dto.KitDTO;
import com.kfir.inventory_be.services.KitsService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/kits")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class KitsRestController {

    @Autowired
    private KitsService kitsService;

    @GetMapping(value = "/")
    public List<KitDTO> getAllKits() {
        return ObjectMapperUtils.mapAll(kitsService.findAll(), KitDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public KitDTO getKitById(@PathVariable("id") UUID kitId) {
        return ObjectMapperUtils.map(kitsService.findKitById(kitId), KitDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<KitDTO> saveOrUpdateKit(@RequestBody KitDTO kitDTO) {
        kitsService.save(ObjectMapperUtils.map(kitDTO, Kit.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{kitId}")
    public ResponseEntity<KitDTO> deleteKitById(@PathVariable("kitId") UUID kitId) {
        kitsService.deleteKitById(kitsService.findKitById(kitId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
