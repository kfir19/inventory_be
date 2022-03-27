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
    private String title;
    private String lblSearch;
    private String tblTitlePersonName;
    private String tblTitlePersonRole;
    private String tblTitleItemType;
    private String tblTitleItemSN;
    private String tblBtnReturnItem;
    private String tblBtnPersonDetails;

    public ItemsOutMetadata() {
    }

    public ItemsOutMetadata(String title, String lblSearch, String tblTitlePersonName, String tblTitlePersonRole, String tblTitleItemType, String tblTitleItemSN, String tblBtnReturnItem, String tblBtnPersonDetails) {
        String idKey = "items_out_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.title = title;
        this.lblSearch = lblSearch;
        this.tblTitlePersonName = tblTitlePersonName;
        this.tblTitlePersonRole = tblTitlePersonRole;
        this.tblTitleItemType = tblTitleItemType;
        this.tblTitleItemSN = tblTitleItemSN;
        this.tblBtnReturnItem = tblBtnReturnItem;
        this.tblBtnPersonDetails = tblBtnPersonDetails;
    }
}
