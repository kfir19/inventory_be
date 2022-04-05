package com.kfir.inventory_be.models.dto.metadata;

import lombok.Data;

import java.util.UUID;

@Data
public class LoanItemsMetadataDTO {

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
}
