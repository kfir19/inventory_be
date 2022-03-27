package com.kfir.inventory_be.repositories.metadata;

import com.kfir.inventory_be.models.metadata.SystemMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SystemMetadataRepository extends MongoRepository<SystemMetadata, UUID> {

    SystemMetadata findSystemMetadataById(UUID id);

    SystemMetadata save(SystemMetadata metadata);

}
