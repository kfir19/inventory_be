package com.kfir.inventory_be.services.metadata;

import com.kfir.inventory_be.models.metadata.SystemMetadata;

import java.util.UUID;

public interface SystemMetadataService {

    SystemMetadata findSystemMetadataById(UUID id);

    SystemMetadata save(SystemMetadata metadata);

}
