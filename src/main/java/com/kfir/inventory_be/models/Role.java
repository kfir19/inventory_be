package com.kfir.inventory_be.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("roles")
public class Role {

    @Id
    private UUID id;

    private String displayName;

    public Role() {
    }

    public Role(String displayName) {
        this.id = UUID.nameUUIDFromBytes(displayName.getBytes());
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}
