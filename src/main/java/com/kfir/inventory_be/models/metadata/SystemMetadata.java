package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("system_metadata")
public class SystemMetadata {

    @Id
    private UUID id;

    /*-------------------------------------*/
    private String btnLblManagePeople;
    private String btnLblManageItems;
    private String btnLblItemsOut;
    private String btnLblLoanItems;
    private String btnLblDefinitions;
}
