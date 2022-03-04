package com.kfir.inventory_be.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class ItemTypeDTO {

    @Id
    private ObjectId id;

    private String type;
    private String displayName;
}
