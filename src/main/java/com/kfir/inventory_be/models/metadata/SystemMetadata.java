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

    public SystemMetadata(String btnLblManagePeople, String btnLblManageItems, String btnLblItemsOut, String btnLblLoanItems, String btnLblDefinitions) {
        String idKey = "system_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.btnLblManagePeople = btnLblManagePeople;
        this.btnLblManageItems = btnLblManageItems;
        this.btnLblItemsOut = btnLblItemsOut;
        this.btnLblLoanItems = btnLblLoanItems;
        this.btnLblDefinitions = btnLblDefinitions;
    }
}
