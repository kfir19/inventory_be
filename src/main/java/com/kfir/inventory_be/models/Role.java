package com.kfir.inventory_be.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("roles")
public class Role {

    @Id
    private ObjectId id;

    private String kind;
    private String displayName;


    public Role(String kind, String displayName){
        this.id = new ObjectId();
        this.kind = kind;
        this.displayName = displayName;
    }

    @Override
    public String toString(){
        return kind;
    }

}
