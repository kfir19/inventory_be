package com.kfir.inventory_be.services.metadata;

import com.kfir.inventory_be.models.metadata.ManageItemsMetadata;

import java.util.UUID;

public interface ManageItemsMetadataService {

    ManageItemsMetadata findManageItemsMetadataById(UUID id);

    ManageItemsMetadata save(ManageItemsMetadata metadata);
}
