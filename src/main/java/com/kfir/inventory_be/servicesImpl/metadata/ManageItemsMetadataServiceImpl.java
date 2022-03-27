package com.kfir.inventory_be.servicesImpl.metadata;

import com.kfir.inventory_be.models.metadata.ManageItemsMetadata;
import com.kfir.inventory_be.repositories.metadata.ManageItemsMetadataRepository;
import com.kfir.inventory_be.services.metadata.ManageItemsMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ManageItemsMetadataServiceImpl implements ManageItemsMetadataService {

    @Autowired
    private ManageItemsMetadataRepository repo;

    @Override
    public ManageItemsMetadata findManageItemsMetadataById(UUID id) {
        return repo.findManageItemsMetadataById(id);
    }

    @Override
    public ManageItemsMetadata save(ManageItemsMetadata metadata) {
        return repo.save(metadata);
    }
}
