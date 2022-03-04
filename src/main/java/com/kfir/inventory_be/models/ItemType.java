package com.kfir.inventory_be.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("item_types")
public class ItemType {

    @Id
    private ObjectId id;

    private String type;
    private String displayName;

    public ItemType (String type, String displayName){
        this.id = new ObjectId();
        this.type = type;
        this.displayName = displayName;
    }

    @Override
    public String toString(){
        return type;
    }

}
