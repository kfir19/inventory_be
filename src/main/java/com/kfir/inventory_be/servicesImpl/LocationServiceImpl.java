package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Location;
import com.kfir.inventory_be.repositories.LocationRepository;
import com.kfir.inventory_be.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repo;

    @Override
    public List<Location> findAll() {
        return repo.findAll();
    }

    @Override
    public Location findLocationById(UUID id) {
        return repo.findLocationById(id);
    }

    @Override
    public Location save(Location location) {
        return repo.save(location);
    }

    @Override
    public List<Location> saveAll(List<Location> locations) {
        return repo.saveAll(locations);
    }

    @Override
    public void deleteLocationById(UUID id) {
        repo.deleteLocationById(id);
    }
}
