package com.kfir.inventory_be.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.UUID;

@Data
@Document("people")
public class Person {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private String imgSrc;
    private Role role;
    private List<UUID> linkedItems;

    public Person(){}

    public Person(String firstName, String lastName, String phoneNumber, String personalNumber,String imgSrc, Role role) {
        String idKey = String.format("%s_%s_%s_%s", firstName, lastName, phoneNumber, personalNumber);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
        this.imgSrc = imgSrc;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", firstName, lastName);
    }

}
