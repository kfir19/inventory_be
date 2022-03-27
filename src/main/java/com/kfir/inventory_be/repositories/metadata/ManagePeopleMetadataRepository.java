package com.kfir.inventory_be.repositories.metadata;

import com.kfir.inventory_be.models.metadata.ManagePeopleMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ManagePeopleMetadataRepository extends MongoRepository<ManagePeopleMetadata, UUID> {

    ManagePeopleMetadata findManagePeopleMetadataById(UUID id);

    ManagePeopleMetadata save(ManagePeopleMetadata metadata);
}
