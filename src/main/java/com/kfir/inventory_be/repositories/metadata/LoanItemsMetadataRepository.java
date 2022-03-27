package com.kfir.inventory_be.repositories.metadata;

import com.kfir.inventory_be.models.metadata.LoanItemsMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface LoanItemsMetadataRepository extends MongoRepository<LoanItemsMetadata, UUID> {

    LoanItemsMetadata findLoanItemsMetadataById(UUID id);

    LoanItemsMetadata save(LoanItemsMetadata metadata);

}
