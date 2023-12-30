package com.kfir.inventory_be.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HistoryDate {

    private String dateTitle;

    private List<HistoryTime> historyTime;

    public HistoryDate(String dateTitle, String time, String message){
        this.dateTitle = dateTitle;
        this.historyTime = new ArrayList<>();
        HistoryTime hTime = new HistoryTime(time,message);
        this.historyTime.add(hTime);
    }




}
