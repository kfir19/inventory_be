package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("items_out_metadata")
public class ItemsOutMetadata {

    /*------ITEMS OUT----------------*/
    private String titleItemsOut;
    private String lblItemsOutSearch;
    private String tblTitleItemsOutPersonName;
    private String tblTitleItemsOutPersonRole;
    private String tblTitleItemsOutItemType;
    private String tblTitleItemsOutItemSN;
    private String tblBtnReturnItem;
    private String tblBtnPersonDetails;

}
