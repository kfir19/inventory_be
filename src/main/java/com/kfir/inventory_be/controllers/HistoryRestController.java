package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.data.AggregatedHistory;
import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.models.dto.HistoryDTO;
import com.kfir.inventory_be.services.HistoryService;
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

    @GetMapping(value = "/allByPersonIdSortedByTimeAsc/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdSortedByTimeAsc(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.findByPersonIdOrderByTimeAsc(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByItemIdSortedByTimeAsc/{id}")
    public List<HistoryDTO> getAllHistoryByItemIdSortedByTimeAsc(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.mapAll(historyService.findByItemIdOrderByTimeAsc(itemId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonIdSortedByDateAsc/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdSortedByDateAsc(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.findByPersonIdOrderByDateAsc(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByItemIdSortedByDateAsc/{id}")
    public List<HistoryDTO> getAllHistoryByItemIdSortedByDateAsc(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.mapAll(historyService.findByItemIdOrderByDateAsc(itemId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonIdSortedByTimeDesc/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdSortedByTimeDesc(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.findByPersonIdOrderByTimeDesc(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByItemIdSortedByTimeDesc/{id}")
    public List<HistoryDTO> getAllHistoryByItemIdSortedByTimeDesc(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.mapAll(historyService.findByItemIdOrderByTimeDesc(itemId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonIdSortedByDateDesc/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdSortedByDateDesc(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.findByPersonIdOrderByDateDesc(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByPersonIdSortedByDateDescTimeDesc/{id}")
    public List<HistoryDTO> getAllHistoryByPersonIdSortedByDateDescTimeDesc(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.mapAll(historyService.findByPersonIdOrderByDateDescTimeDesc(personId), HistoryDTO.class);
    }

    @GetMapping(value = "/allByItemIdSortedByDateDesc/{id}")
    public List<HistoryDTO> getAllHistoryByItemIdSortedByDateDesc(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.mapAll(historyService.findByItemIdOrderByDateDesc(itemId), HistoryDTO.class);
    }

    @GetMapping(value = "/aggregatedByPersonId/{id}")
    public AggregatedHistory getAggregatedHistoryByPersonId(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.map(historyService.findAggregatedHistoryByPersonId(personId), AggregatedHistory.class);
    }

    @GetMapping(value = "/aggregatedByItemId/{id}")
    public AggregatedHistory getAggregatedHistoryByItemId(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.map(historyService.findAggregatedHistoryByItemId(itemId), AggregatedHistory.class);
    }
}
