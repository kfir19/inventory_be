package com.kfir.inventory_be.services.metadata;

import com.kfir.inventory_be.models.metadata.ManagePeopleMetadata;

import java.util.UUID;

public interface ManagePeopleMetadataService {

    ManagePeopleMetadata findManagePeopleMetadataById(UUID id);

    ManagePeopleMetadata save(ManagePeopleMetadata metadata);

}
