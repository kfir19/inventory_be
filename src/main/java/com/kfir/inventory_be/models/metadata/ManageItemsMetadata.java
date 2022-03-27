package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("system_metadata")
public class ManageItemsMetadata {

    @Id
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

    public ManageItemsMetadata(String title, String lblItemsSearch, String btnLblAddNewItem, String tblTitleItemType, String tblTitleItemSN, String tblBtnDeleteItem, String titleAddNewItem, String wtrMrkItemType, String wtrMrkSerialNumber, String btnLblCloseNewItem, String btnLblSaveNewItem) {
        String idKey = "manage_items_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.title = title;
        this.lblItemsSearch = lblItemsSearch;
        this.btnLblAddNewItem = btnLblAddNewItem;
        this.tblTitleItemType = tblTitleItemType;
        this.tblTitleItemSN = tblTitleItemSN;
        this.tblBtnDeleteItem = tblBtnDeleteItem;
        this.titleAddNewItem = titleAddNewItem;
        this.wtrMrkItemType = wtrMrkItemType;
        this.wtrMrkSerialNumber = wtrMrkSerialNumber;
        this.btnLblCloseNewItem = btnLblCloseNewItem;
        this.btnLblSaveNewItem = btnLblSaveNewItem;
    }
}
