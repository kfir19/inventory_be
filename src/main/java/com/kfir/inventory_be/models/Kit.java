package com.kfir.inventory_be.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document("kits")
public class Kit {

    @Id
    private UUID id;
    private UUID kitOwnerId;
    private UUID leadingItemId;
    private List<UUID> kitItemsIds;

    public Kit() {
    }

    public Kit(UUID kitOwnerId, UUID leadingItemId, List<UUID> kitItemsIds) {
        String idKey = String.format("%s_%s_%s", kitOwnerId, leadingItemId);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.kitOwnerId = kitOwnerId;
        this.leadingItemId = leadingItemId;
        this.kitItemsIds = kitItemsIds;
    }
}
