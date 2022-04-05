package com.kfir.inventory_be.models.dto.metadata;

import lombok.Data;

import java.util.UUID;

@Data
public class ManagePeopleMetadataDTO {

    private UUID id;

    /*------ MANAGE PEOPLE ----------------*/
    private String title;
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
