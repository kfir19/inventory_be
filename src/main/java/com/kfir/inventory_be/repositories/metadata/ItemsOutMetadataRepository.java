package com.kfir.inventory_be.repositories.metadata;

import com.kfir.inventory_be.models.metadata.ItemsOutMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ItemsOutMetadataRepository extends MongoRepository<ItemsOutMetadata, UUID> {

    ItemsOutMetadata findItemsOutMetadataById(UUID id);

    ItemsOutMetadata save(ItemsOutMetadata metadata);

}
