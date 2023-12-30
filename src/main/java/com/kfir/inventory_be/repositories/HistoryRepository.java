package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.data.AggregatedHistory;
import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository extends MongoRepository<History, UUID> {

    List<History> getAllByItemId(UUID id);

    List<History> getAllByPersonId(UUID id);

    List<History> findByPersonIdOrderByTimeAsc(UUID id);

    List<History> findByItemIdOrderByTimeAsc(UUID id);

    List<History> findByPersonIdOrderByDateAsc(UUID id);

    List<History> findByItemIdOrderByDateAsc(UUID id);

    List<History> findByPersonIdOrderByTimeDesc(UUID id);

    List<History> findByItemIdOrderByTimeDesc(UUID id);

    List<History> findByPersonIdOrderByDateDesc(UUID id);

    List<History> findByItemIdOrderByDateDesc(UUID id);

    AggregatedHistory findAggregatedHistoryByPersonId(UUID id);

    AggregatedHistory findAggregatedHistoryByItemId(UUID id);
    @Override
    <S extends History> List<S> saveAll(Iterable<S> histories);
}
