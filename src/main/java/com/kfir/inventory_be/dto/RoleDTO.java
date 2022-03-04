package com.kfir.inventory_be.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class RoleDTO {

    @Id
    private ObjectId id;

    private String kind;
    private String displayName;
}
