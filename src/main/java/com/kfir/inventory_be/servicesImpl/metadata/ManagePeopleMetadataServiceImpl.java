package com.kfir.inventory_be.servicesImpl.metadata;

import com.kfir.inventory_be.models.metadata.ManagePeopleMetadata;
import com.kfir.inventory_be.repositories.metadata.ManagePeopleMetadataRepository;
import com.kfir.inventory_be.services.metadata.ManagePeopleMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ManagePeopleMetadataServiceImpl implements ManagePeopleMetadataService {

    @Autowired
    private ManagePeopleMetadataRepository repo;

    @Override
    public ManagePeopleMetadata findManagePeopleMetadataById(UUID id) {
        return repo.findManagePeopleMetadataById(id);
    }

    @Override
    public ManagePeopleMetadata save(ManagePeopleMetadata metadata) {
        return repo.save(metadata);
    }
}
