package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.models.Location;
import com.kfir.inventory_be.models.dto.ItemTypeDTO;
import com.kfir.inventory_be.models.dto.LocationDTO;
import com.kfir.inventory_be.services.ItemTypesService;
import com.kfir.inventory_be.services.LocationService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class LocationRestController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/")
    public List<LocationDTO> getAllItemTypes() {
        return ObjectMapperUtils.mapAll(locationService.findAll(), LocationDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public LocationDTO getItemTypeById(@PathVariable("id") UUID locationId) {
        return ObjectMapperUtils.map(locationService.findLocationById(locationId), LocationDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<LocationDTO> saveOrUpdateItemType(@RequestBody LocationDTO locationDTO) {
        try {
            locationService.save(ObjectMapperUtils.map(locationDTO, Location.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<List<LocationDTO>> saveOrUpdateItem(@RequestBody List<LocationDTO> locationDTO) {
        try {
            locationService.saveAll(ObjectMapperUtils.mapAll(locationDTO, Location.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/delete/{locationId}")
    public ResponseEntity<LocationDTO> deleteLocationById(@PathVariable("locationId") UUID locationId) {
        try {
            locationService.deleteLocationById(locationId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
