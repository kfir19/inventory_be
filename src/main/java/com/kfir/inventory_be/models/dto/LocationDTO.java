package com.kfir.inventory_be.models.dto;

import com.kfir.inventory_be.data.SubLocation;
import lombok.Data;
import org.modelmapper.internal.Pair;

import java.util.List;
import java.util.UUID;

@Data
public class LocationDTO {
    private UUID id;
    private String typeId;
    private String displayName;

    //list of sublocation - type id, display name
    private List<SubLocation> sublocation;
}
