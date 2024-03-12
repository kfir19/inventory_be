package com.kfir.inventory_be.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemTypeDTO {

    private UUID id;

    private String typeId;
    private String displayName;
    private boolean basic;
}
