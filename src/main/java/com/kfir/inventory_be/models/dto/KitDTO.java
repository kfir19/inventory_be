package com.kfir.inventory_be.models.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class KitDTO {
    private UUID id;
    private UUID kitOwnerId;
    private String displayName;
    private List<UUID> kitItemsIds;
}
