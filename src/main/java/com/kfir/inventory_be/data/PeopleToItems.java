package com.kfir.inventory_be.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PeopleToItems {

    private List<PersonToItems> peopleToItems;

    public PeopleToItems(){
        this.peopleToItems = new ArrayList<>();
    }
}
