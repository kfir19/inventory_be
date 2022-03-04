package com.kfir.inventory_be;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.services.ItemsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryBeApplicationTests {

	@Autowired
	private ItemsService itemsService;

	@Test
	void createItems(){

		Item item1 = new Item(1, new ItemType("CAMERA","מצלמה"));
		Item result =  itemsService.saveOrUpdateItem(item1);
		Assertions.assertNotNull(result);
	}

}
