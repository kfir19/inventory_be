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
    void createItems() {

        for (int i = 1; i < 4; i++) {
            Item item1 = new Item(i, new ItemType("CAMERA", "מצלמה " + i));
            Item result1 = itemsService.saveOrUpdateItem(item1);
            Assertions.assertNotNull(result1);

            Item item2 = new Item(i, new ItemType("TAG", "תג " + i));
            Item result2 = itemsService.saveOrUpdateItem(item2);
            Assertions.assertNotNull(result2);

            Item item3 = new Item(i, new ItemType("PENCIL", "עיפרון " + i));
            Item result3 = itemsService.saveOrUpdateItem(item3);
            Assertions.assertNotNull(result3);

            Item item4 = new Item(i, new ItemType("SUIT", "חליפה " + i));
            Item result4 = itemsService.saveOrUpdateItem(item4);
            Assertions.assertNotNull(result4);
        }
    }

    @Test
    void createItemTypes() {

        ItemType itemType1 = new ItemType("CAMERA", "מצלמה");
        ItemType result1 = itemTypesService.saveOrUpdateItemType(itemType1);
        Assertions.assertNotNull(result1);

        ItemType itemType2 = new ItemType("TAG", "תג");
        ItemType result2 = itemTypesService.saveOrUpdateItemType(itemType2);
        Assertions.assertNotNull(result2);

        ItemType itemType3 = new ItemType("PENCIL", "עיפרון");
        ItemType result3 = itemTypesService.saveOrUpdateItemType(itemType3);
        Assertions.assertNotNull(result3);

        ItemType itemType4 = new ItemType("SUIT", "חליפה");
        ItemType result4 = itemTypesService.saveOrUpdateItemType(itemType4);
        Assertions.assertNotNull(result4);
    }

    @Test
    void createRoles() {

        Role role1 = new Role("RESERVE", "מילואים");
        Role result1 = rolesService.saveOrUpdateRole(role1);
        Assertions.assertNotNull(result1);

        Role role2 = new Role("RECRUIT", "סדיר");
        Role result2 = rolesService.saveOrUpdateRole(role2);
        Assertions.assertNotNull(result2);

        Role role3 = new Role("EMA", "הצ'ח");
        Role result3 = rolesService.saveOrUpdateRole(role3);
        Assertions.assertNotNull(result3);

        Role role4 = new Role("GUEST", "אורח");
        Role result4 = rolesService.saveOrUpdateRole(role4);
        Assertions.assertNotNull(result4);
    }

    @Test
    void createPeople() {

        Person person1 = new Person("כפיר", "גבאי", "0524697526", "7088703", "../../pic", new Role("RESERVE", "מילואים"));
        Person result1 = peopleService.saveOrUpdatePerson(person1);
        Assertions.assertNotNull(result1);

        Person person2 = new Person("כרמית", "גבאי", "0524690435", "1234567", "../../pic", new Role("RECRUIT", "סדיר"));
        Person result2 = peopleService.saveOrUpdatePerson(person2);
        Assertions.assertNotNull(result2);

        Person person3 = new Person("עומר", "גבאי", "0514682513", "7654321", "../../pic", new Role("EMA", "הצ'ח"));
        Person result3 = peopleService.saveOrUpdatePerson(person3);
        Assertions.assertNotNull(result3);

        Person person4 = new Person("עמית", "גבאי", "0545872213", "9632587", "../../pic", new Role("GUEST", "אורח"));
        Person result4 = peopleService.saveOrUpdatePerson(person4);
        Assertions.assertNotNull(result4);
    }
}
