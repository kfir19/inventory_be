package com.kfir.inventory_be.models.metadata;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("system_metadata")
public class ManagePeopleMetadata {

    @Id
    private UUID id;

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

    public ManagePeopleMetadata(String titleManagePeople, String lblPeopleSearch, String btnLblAddNewPerson, String btnLblEditPerson, String btnLblDeletePerson, String titleAddNewPerson, String wtrMrkFirstName, String wtrMrkLastName, String wtrMrkPhoneNumber, String wtrMrkPersonalNumber, String wtrMrkRole, String wtrMrkPicture, String btnLblCloseNewPerson, String btnLblSaveNewPerson) {
        String idKey = "manage_people_metadata";
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.titleManagePeople = titleManagePeople;
        this.lblPeopleSearch = lblPeopleSearch;
        this.btnLblAddNewPerson = btnLblAddNewPerson;
        this.btnLblEditPerson = btnLblEditPerson;
        this.btnLblDeletePerson = btnLblDeletePerson;
        this.titleAddNewPerson = titleAddNewPerson;
        this.wtrMrkFirstName = wtrMrkFirstName;
        this.wtrMrkLastName = wtrMrkLastName;
        this.wtrMrkPhoneNumber = wtrMrkPhoneNumber;
        this.wtrMrkPersonalNumber = wtrMrkPersonalNumber;
        this.wtrMrkRole = wtrMrkRole;
        this.wtrMrkPicture = wtrMrkPicture;
        this.btnLblCloseNewPerson = btnLblCloseNewPerson;
        this.btnLblSaveNewPerson = btnLblSaveNewPerson;
    }
}
