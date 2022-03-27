package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("manage_people_metadata")
public class ManagePeopleMetadata {

    /*------ MANAGE PEOPLE ----------------*/
    private String titleManagePeople;
    private String lblPeopleSearch;
    private String btnLblAddNewPerson;
    private String btnLblEditPerson;
    private String btnLblDeletePerson;

    /*------ADD NEW PERSON-----------------*/
    private String titleAddNewPerson;
    private String wtrMrkFirstName;
    private String wtrMrkLastName;
    private String wtrMrkPhoneNumber;
    private String wtrMrkPersonalNumber;
    private String wtrMrkRole;
    private String wtrMrkPicture;
    private String btnLblCloseNewPerson;
    private String btnLblSaveNewPerson;
}
