package com.kfir.inventory_be.services.metadata;

import com.kfir.inventory_be.models.metadata.ItemsOutMetadata;

import java.util.UUID;

public interface ItemsOutMetadataService {

    ItemsOutMetadata findItemsOutMetadataById(UUID id);

    ItemsOutMetadata save(ItemsOutMetadata metadata);

}
