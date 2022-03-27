package com.kfir.inventory_be.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("item_types")
public class ItemType {

    @Id
    private UUID id;

    private String type;
    private String displayName;


    public ItemType() {
    }

    public ItemType(String type, String displayName) {
        String idKey = String.format("%s_%s", type, displayName);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.type = type;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return type;
    }

}
