package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.models.Item;

import java.util.List;
import java.util.UUID;

public interface HistoryService {

    List<History> getAllByItemId(UUID id);

    List<History> getAllByPersonId(UUID id);

    List<History> findByPersonIdOrderByTimeAsc(UUID id);

    List<History> getHistoryByPersonIdOrderByDate(UUID id);

    List<History> saveAll(List<History> histories);
}
