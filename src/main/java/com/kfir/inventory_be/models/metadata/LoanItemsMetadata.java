package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("system_metadata")
public class LoanItemsMetadata {

    @Id
    private UUID id;

    /*------LOAN ITEMS----------------*/
    private String title;
    private String wtrMrkSelectPerson;
    private String btnLblClearPersonSelection;
    private String tblTitleItemType;
    private String tblTitleItemSN;

    /*------ASSIGN NEW ITEM TO PERSON----------------*/
    private String titleAssignToPerson;
    private String wtrMrkSelectItem;
    private String btnLblAddSelectionToList;
    private String btnLblCloseAssignToPerson;
    private String btnLblSaveAssignmentToPerson;
    private String btnLblSaveChanges;

    public LoanItemsMetadata(String title, String wtrMrkSelectPerson, String btnLblClearPersonSelection, String tblTitleItemType, String tblTitleItemSN, String titleAssignToPerson, String wtrMrkSelectItem, String btnLblAddSelectionToList, String btnLblCloseAssignToPerson, String btnLblSaveAssignmentToPerson, String btnLblSaveChanges) {
        String idKey = "loan_items_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.title = title;
        this.wtrMrkSelectPerson = wtrMrkSelectPerson;
        this.btnLblClearPersonSelection = btnLblClearPersonSelection;
        this.tblTitleItemType = tblTitleItemType;
        this.tblTitleItemSN = tblTitleItemSN;
        this.titleAssignToPerson = titleAssignToPerson;
        this.wtrMrkSelectItem = wtrMrkSelectItem;
        this.btnLblAddSelectionToList = btnLblAddSelectionToList;
        this.btnLblCloseAssignToPerson = btnLblCloseAssignToPerson;
        this.btnLblSaveAssignmentToPerson = btnLblSaveAssignmentToPerson;
        this.btnLblSaveChanges = btnLblSaveChanges;
    }
}
