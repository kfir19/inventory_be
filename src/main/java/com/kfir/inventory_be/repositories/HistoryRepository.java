package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository extends MongoRepository<History, UUID> {

    List<History> getAllByItemId(UUID id);

    List<History> getAllByPersonId(UUID id);

    List<History> findByPersonIdOrderByTimeAsc(UUID id);

    List<History> getHistoryByPersonIdOrderByDate(UUID id);
    @Override
    <S extends History> List<S> saveAll(Iterable<S> histories);
}
