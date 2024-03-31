package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.models.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface LocationRepository extends MongoRepository<Location, UUID> {

    List<Location> findAll();

    Location findLocationById(UUID id);

    Location save(Location location);

    @Override
    <S extends Location> List<S> saveAll(Iterable<S> entities);

    void deleteLocationById(UUID id);

}
