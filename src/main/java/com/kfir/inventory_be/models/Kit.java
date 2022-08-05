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
    private String displayName;
    private List<UUID> kitItemsIds;

    public Kit() {
    }

    public Kit(UUID kitOwnerId, String displayName, List<UUID> kitItemsIds) {
        String idKey = String.format("%s", displayName);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.displayName = displayName;
        this.kitOwnerId = kitOwnerId;
        this.kitItemsIds = kitItemsIds;
    }
}
