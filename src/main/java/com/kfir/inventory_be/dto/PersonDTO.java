package com.kfir.inventory_be.dto;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class PersonDTO {

    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private RoleDTO role;
    private List<ObjectId> linkedItems;

}
