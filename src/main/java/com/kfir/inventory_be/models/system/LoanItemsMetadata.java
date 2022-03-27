package com.kfir.inventory_be.models.system;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("loan_items_metadata")
public class LoanItemsMetadata {

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

}
