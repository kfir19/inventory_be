package com.kfir.inventory_be.servicesImpl.metadata;

import com.kfir.inventory_be.models.metadata.LoanItemsMetadata;
import com.kfir.inventory_be.repositories.metadata.LoanItemsMetadataRepository;
import com.kfir.inventory_be.services.metadata.LoanItemsMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoanItemsMetadataServiceImpl implements LoanItemsMetadataService {

    @Autowired
    private LoanItemsMetadataRepository repo;

    @Override
    public LoanItemsMetadata findLoanItemsMetadataById(UUID id) {
        return repo.findLoanItemsMetadataById(id);
    }

    @Override
    public LoanItemsMetadata save(LoanItemsMetadata metadata) {
        return repo.save(metadata);
    }
}
