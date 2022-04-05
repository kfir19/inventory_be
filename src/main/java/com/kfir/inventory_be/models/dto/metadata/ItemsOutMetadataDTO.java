package com.kfir.inventory_be.models.dto.metadata;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemsOutMetadataDTO {

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
}
