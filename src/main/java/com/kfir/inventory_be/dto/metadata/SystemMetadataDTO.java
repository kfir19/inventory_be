package com.kfir.inventory_be.dto.metadata;

import lombok.Data;

import java.util.UUID;

@Data
public class SystemMetadataDTO {

    private UUID id;

    /*-------------------------------------*/
    private String btnLblManagePeople;
    private String btnLblManageItems;
    private String btnLblItemsOut;
    private String btnLblLoanItems;
    private String btnLblDefinitions;
}
