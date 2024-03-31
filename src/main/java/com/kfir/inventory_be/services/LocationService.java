package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {

    List<Location> findAll();

    Location findLocationById(UUID id);

    Location save(Location location);

    List<Location> saveAll(List<Location> locations);

    void deleteLocationById(UUID id);

}
