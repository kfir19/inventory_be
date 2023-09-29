package com.kfir.inventory_be.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document("items")
public class Item {

    @Id
    private UUID id;
    private UUID linkedPerson;
    private int serialNumber;
    private boolean isInStock;
    private boolean isSuggested;
    private UUID linkedKit;
    private ItemType type;
    private String timeStamp;
    private List<UUID> kitItemsIds;
    private boolean isTypeKit;

    public Item() {
    }

    public Item(int serialNumber, ItemType type) {
        String idKey = String.format("%s_%s", serialNumber, type.getTypeId());
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.serialNumber = serialNumber;
        this.type = type;
        this.isInStock = true;
        this.isSuggested = false;
        this.isTypeKit = false;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", type.toString(), serialNumber);
    }

}
