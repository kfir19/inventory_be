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

    private String kind;
    private String displayName;

    public Role() {
    }

    public Role(String kind, String displayName) {
        String idKey = String.format("%s_%s", kind, displayName);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.kind = kind;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return kind;
    }

}
