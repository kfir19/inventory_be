package com.kfir.inventory_be.models;

import com.kfir.inventory_be.data.SubLocation;
import lombok.Data;
import org.modelmapper.internal.Pair;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document("locations")
public class Location {

    @Id
    private UUID id;
    private String typeId;
    private String displayName;

    //list of sublocation - type id, display name
    private List<SubLocation> sublocation;

    public Location() {
    }

    public Location(String locationTypeId, String locationDisplayName) {
        String idKey = String.format("%s_%s", locationTypeId, locationDisplayName);
        this.id = UUID.nameUUIDFromBytes(idKey.getBytes());
        this.typeId = locationTypeId;
        this.displayName = locationDisplayName;
        this.sublocation = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.displayName;
    }

}
