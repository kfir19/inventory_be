package com.kfir.inventory_be.models.dto;

import lombok.Data;

import java.util.Set;
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
    private Set<UUID> linkedItems;
    private Set<UUID> suggestedItems;

}
