package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("system_metadata")
public class ItemsOutMetadata {

    @Id
    private UUID id;

    /*------ITEMS OUT----------------*/
    private String titleItemsOut;
    private String lblItemsOutSearch;
    private String tblTitleItemsOutPersonName;
    private String tblTitleItemsOutPersonRole;
    private String tblTitleItemsOutItemType;
    private String tblTitleItemsOutItemSN;
    private String tblBtnReturnItem;
    private String tblBtnPersonDetails;

    public ItemsOutMetadata(){}

    public ItemsOutMetadata(String titleItemsOut, String lblItemsOutSearch, String tblTitleItemsOutPersonName, String tblTitleItemsOutPersonRole, String tblTitleItemsOutItemType, String tblTitleItemsOutItemSN, String tblBtnReturnItem, String tblBtnPersonDetails) {
        String idKey = "items_out_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.titleItemsOut = titleItemsOut;
        this.lblItemsOutSearch = lblItemsOutSearch;
        this.tblTitleItemsOutPersonName = tblTitleItemsOutPersonName;
        this.tblTitleItemsOutPersonRole = tblTitleItemsOutPersonRole;
        this.tblTitleItemsOutItemType = tblTitleItemsOutItemType;
        this.tblTitleItemsOutItemSN = tblTitleItemsOutItemSN;
        this.tblBtnReturnItem = tblBtnReturnItem;
        this.tblBtnPersonDetails = tblBtnPersonDetails;
    }
}
