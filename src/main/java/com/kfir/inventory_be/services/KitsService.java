package com.kfir.inventory_be.services;

import java.util.List;
import java.util.UUID;

public interface KitsService {

    List<Kit> findAll();

    Kit findKitById(UUID id);

    Kit save(Kit kit);

    void deleteKitById(UUID id);

}
