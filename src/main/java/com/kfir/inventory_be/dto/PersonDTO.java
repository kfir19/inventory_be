package com.kfir.inventory_be.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO {

    private UUID id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private String imgSrc;
    private RoleDTO role;
    private List<UUID> linkedItems;

}
