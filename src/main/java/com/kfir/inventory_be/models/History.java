package com.kfir.inventory_be.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("histories")
public class History {

    @Id
    private UUID id;
    private String date;
    private String time;
    private UUID itemId;
    private UUID personId;
    private String displayName;
    private String serialNumber;
    private String message;

    public History() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return message;
    }

}
