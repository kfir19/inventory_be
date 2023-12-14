package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.dto.HistoryDTO;
import com.kfir.inventory_be.models.dto.ItemDTO;
import com.kfir.inventory_be.services.HistoryService;
import com.kfir.inventory_be.services.ItemsService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/histories")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class HistoryRestController {

    @Autowired
    private HistoryService historyService;

    @PostMapping(value = "/saveAll")
    public ResponseEntity<List<HistoryDTO>> saveAll(@RequestBody List<HistoryDTO> historyDTO) {
        try {
            historyService.saveAll(ObjectMapperUtils.mapAll(historyDTO, History.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/allByItemId/{id}")
    public List<HistoryDTO> getAllHistoryByItemId(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.mapAll(historyService.getAllByItemId(itemId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonId/{id}")
    public List<HistoryDTO> getAllHistoryByPersonId(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.getAllByPersonId(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonIdSorted/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdSorted(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.findByPersonIdOrderByTimeAsc(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonIdAggregated/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdAggregated(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.getHistoryByPersonIdOrderByDate(personId), HistoryDTO.class);
    }
}
