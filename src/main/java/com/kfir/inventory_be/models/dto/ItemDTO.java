package com.kfir.inventory_be.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemDTO {

    private UUID id;
    private UUID linkedPerson;
    private int serialNumber;
    private boolean isInStock;
    private ItemTypeDTO type;
    private String barcodeValue;
    private boolean isSuggested;
}
