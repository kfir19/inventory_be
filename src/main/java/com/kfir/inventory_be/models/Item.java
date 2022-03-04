package com.kfir.inventory_be.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("items")
public class Item {

    @Id
    private ObjectId id;
    private ObjectId linkedPerson;

    private int serialNumber;
    private boolean isInStock;
    private ItemType type;


    public Item(int serialNumber, ItemType type) {
        this.id = new ObjectId();
        this.serialNumber = serialNumber;
        this.type = type;
        this.isInStock = true;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", type.toString(), serialNumber);
    }

}
