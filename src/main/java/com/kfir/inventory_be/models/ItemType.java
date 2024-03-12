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

    private String typeId;
    private String displayName;
    private boolean basic;


    public ItemType() {
    }

    public ItemType(String typeId, String displayName) {
        String idKey = String.format("%s_%s", typeId, displayName);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.typeId = typeId;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

}
