package com.kfir.inventory_be.models.dto.metadata;

import lombok.Data;

import java.util.UUID;

@Data
public class ManageItemsMetadataDTO {

    private UUID id;

    /*------ MANAGE ITEMS ----------------*/
    private String title;
    private String lblItemsSearch;
    private String btnLblAddNewItem;
    private String tblTitleItemType;
    private String tblTitleItemSN;
    private String tblBtnDeleteItem;

    /*------ADD NEW ITEM-----------------*/
    private String titleAddNewItem;
    private String wtrMrkItemType;
    private String wtrMrkSerialNumber;
    private String btnLblCloseNewItem;
    private String btnLblSaveNewItem;
}
