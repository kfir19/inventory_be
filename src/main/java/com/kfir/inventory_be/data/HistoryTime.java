package com.kfir.inventory_be.data;

import lombok.Data;

@Data
public class HistoryTime {

    private String timeTitle;
    private String message;

    public HistoryTime(String timeTitle, String message){
        this.timeTitle = timeTitle;
        this.message = message;
    }
}
