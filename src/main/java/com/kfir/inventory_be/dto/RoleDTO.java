package com.kfir.inventory_be.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleDTO {

    private UUID id;

    private String kind;
    private String displayName;
}
