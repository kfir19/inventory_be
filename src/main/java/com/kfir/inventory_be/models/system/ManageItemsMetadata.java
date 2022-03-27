package com.kfir.inventory_be.models.system;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("manage_items_metadata")
public class ManageItemsMetadata {

    /*------ MANAGE ITEMS ----------------*/
    private String titleManageItems;
    private String lblItemsSearch;
    private String btnLblAddNewItem;
    private String tblTitleManageItemsItemType;
    private String tblTitleManageItemsItemSN;
    private String tblBtnDeleteItem;

    /*------ADD NEW ITEM-----------------*/
    private String titleAddNewItem;
    private String wtrMrkItemType;
    private String wtrMrkSerialNumber;
    private String btnLblCloseNewItem;
    private String btnLblSaveNewItem;

}
