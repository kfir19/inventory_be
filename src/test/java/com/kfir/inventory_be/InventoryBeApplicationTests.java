package com.kfir.inventory_be;

import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.ItemType;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.models.Role;
import com.kfir.inventory_be.services.ItemTypesService;
import com.kfir.inventory_be.services.ItemsService;
import com.kfir.inventory_be.services.PeopleService;
import com.kfir.inventory_be.services.RolesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryBeApplicationTests {

	@Autowired
	private ItemsService itemsService;
	@Autowired
	private ItemTypesService itemTypesService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private PeopleService peopleService;

	@Test
	void createItems(){

		Item item1 = new Item(1, new ItemType("CAMERA","מצלמה"));
		Item result =  itemsService.saveOrUpdateItem(item1);
		Assertions.assertNotNull(result);
	}

	@Test
	void createItemTypes(){

		ItemType itemType1 = new ItemType("CAMERA","מצלמה");
		ItemType result = itemTypesService.saveOrUpdateItemType(itemType1);
		Assertions.assertNotNull(result);

	}

	@Test
	void createRoles(){

		Role role1 = new Role("RESERVE","מילואים");
		Role result = rolesService.saveOrUpdateRole(role1);
		Assertions.assertNotNull(result);
	}

	@Test
	void createPeople(){

		Person person1 = new Person("כפיר","גבאי","0524697526","7088703",new Role("RESERVE", "מילואים"));
		Person result = peopleService.saveOrUpdatePerson(person1);
		Assertions.assertNotNull(result);
	}

}
