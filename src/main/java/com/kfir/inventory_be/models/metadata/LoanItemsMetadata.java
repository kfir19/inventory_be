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
    private String titleLoanItems;
    private String wtrMrkSelectPerson;
    private String btnLblClearPersonSelection;
    private String tblTitleLoanItemsItemType;
    private String tblTitleLoanItemsItemSN;

    /*------ASSIGN NEW ITEM TO PERSON----------------*/
    private String titleAssignToPerson;
    private String wtrMrkSelectItem;
    private String btnLblAddSelectionToList;
    private String btnLblCloseAssignToPerson;
    private String btnLblSaveAssignmentToPerson;
    private String btnLblSaveChanges;

    public LoanItemsMetadata(String titleLoanItems, String wtrMrkSelectPerson, String btnLblClearPersonSelection, String tblTitleLoanItemsItemType, String tblTitleLoanItemsItemSN, String titleAssignToPerson, String wtrMrkSelectItem, String btnLblAddSelectionToList, String btnLblCloseAssignToPerson, String btnLblSaveAssignmentToPerson, String btnLblSaveChanges) {
        String idKey = "loan_items_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.titleLoanItems = titleLoanItems;
        this.wtrMrkSelectPerson = wtrMrkSelectPerson;
        this.btnLblClearPersonSelection = btnLblClearPersonSelection;
        this.tblTitleLoanItemsItemType = tblTitleLoanItemsItemType;
        this.tblTitleLoanItemsItemSN = tblTitleLoanItemsItemSN;
        this.titleAssignToPerson = titleAssignToPerson;
        this.wtrMrkSelectItem = wtrMrkSelectItem;
        this.btnLblAddSelectionToList = btnLblAddSelectionToList;
        this.btnLblCloseAssignToPerson = btnLblCloseAssignToPerson;
        this.btnLblSaveAssignmentToPerson = btnLblSaveAssignmentToPerson;
        this.btnLblSaveChanges = btnLblSaveChanges;
    }
}
