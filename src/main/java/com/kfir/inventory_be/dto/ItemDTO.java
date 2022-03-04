package com.kfir.inventory_be.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class ItemDTO {

    @Id
    private ObjectId id;
    private ObjectId linkedPerson;

    private int serialNumber;
    private boolean isInStock;
    private ItemTypeDTO type;
}
