package com.kfir.inventory_be.services.metadata;

import com.kfir.inventory_be.models.metadata.LoanItemsMetadata;

import java.util.UUID;

public interface LoanItemsMetadataService {

    LoanItemsMetadata findLoanItemsMetadataById(UUID id);

    LoanItemsMetadata save(LoanItemsMetadata metadata);
}
