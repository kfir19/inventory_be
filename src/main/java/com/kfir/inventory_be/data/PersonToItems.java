package com.kfir.inventory_be.data;

import com.kfir.inventory_be.models.Item;
import lombok.Data;

import java.util.UUID;

@Data
public class PersonToItems {

    private UUID personId;
    private Iterable<Item> personItems;


    public PersonToItems(UUID personId, Iterable<Item> items){
        this.personId = personId;
        this.personItems = items;
    }

}
