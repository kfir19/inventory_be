package com.kfir.inventory_be.models;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("persons")
public class Person {

    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private Role role;
    private List<ObjectId> linkedItems;


    public Person(String firstName, String lastName, String phoneNumber, String personalNumber, Role role) {
        this.id = new ObjectId();

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", firstName, lastName);
    }

}
