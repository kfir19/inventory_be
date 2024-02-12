package com.kfir.inventory_be.models.dto;

import com.kfir.inventory_be.models.ItemType;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ItemDTO {

    private UUID id;
    private UUID linkedPerson;
    private String serialNumber;
    private boolean isInStock;
    private boolean isSuggested;
    private UUID linkedKit;
    private ItemType type;
    private String timeStamp;
    private List<UUID> kitItemsIds;
    private boolean isTypeKit;
    private boolean isExpired;
    private LocalDate expirationDate;
}
