package com.kfir.inventory_be.models.dto;

import com.kfir.inventory_be.models.ItemType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ItemDTO {

    private UUID id;
    private UUID linkedPerson;
    private int serialNumber;
    private boolean isInStock;
    private boolean isSuggested;
    private UUID linkedKit;
    private ItemType type;
    private String barcodeValue;
    private String timeStamp;
    private String kitDisplayName;
    private List<UUID> kitItemsIds;
    private boolean isTypeKit;
}
