package com.kfir.inventory_be.servicesImpl.metadata;

import com.kfir.inventory_be.models.metadata.ItemsOutMetadata;
import com.kfir.inventory_be.repositories.metadata.ItemsOutMetadataRepository;
import com.kfir.inventory_be.services.metadata.ItemsOutMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemsOutMetadataServiceImpl implements ItemsOutMetadataService {

    @Autowired
    private ItemsOutMetadataRepository repo;

    @Override
    public ItemsOutMetadata findItemsOutMetadataById(UUID id) {
        return repo.findItemsOutMetadataById(id);
    }

    @Override
    public ItemsOutMetadata save(ItemsOutMetadata metadata) {
        return repo.save(metadata);
    }
}
