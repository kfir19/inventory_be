package com.kfir.inventory_be.servicesImpl.metadata;

import com.kfir.inventory_be.models.metadata.SystemMetadata;
import com.kfir.inventory_be.repositories.metadata.SystemMetadataRepository;
import com.kfir.inventory_be.services.metadata.SystemMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SystemMetadataServiceImpl implements SystemMetadataService {

    @Autowired
    private SystemMetadataRepository repo;

    @Override
    public SystemMetadata findSystemMetadataById(UUID id) {
        return repo.findSystemMetadataById(id);
    }

    @Override
    public SystemMetadata save(SystemMetadata metadata) {
        return repo.save(metadata);
    }
}
