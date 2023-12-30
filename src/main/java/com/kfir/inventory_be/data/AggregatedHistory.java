package com.kfir.inventory_be.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AggregatedHistory {

    private String title;

    private List<HistoryDate> historyDate;

    public AggregatedHistory(String title){
        this.title = title;
        this.historyDate = new ArrayList<>();
    }

}
