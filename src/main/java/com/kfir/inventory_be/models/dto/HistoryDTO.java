package com.kfir.inventory_be.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HistoryDTO {
    private UUID id;
    private String date;
    private String time;
    private UUID itemId;
    private UUID personId;
    private String displayName;
    private int serialNumber;
    private String message;
}
