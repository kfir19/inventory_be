package com.kfir.inventory_be.repositories.metadata;

import com.kfir.inventory_be.models.metadata.ManageItemsMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ManageItemsMetadataRepository extends MongoRepository<ManageItemsMetadata, UUID> {

    ManageItemsMetadata findManageItemsMetadataById(UUID id);

    ManageItemsMetadata save(ManageItemsMetadata metadata);

}
