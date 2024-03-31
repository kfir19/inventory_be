package com.kfir.inventory_be.data;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class SubLocation {

    @Id
    private UUID id;
    private String typeId;
    private String displayName;
}
