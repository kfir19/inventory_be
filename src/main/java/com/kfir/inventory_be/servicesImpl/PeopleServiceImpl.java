package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.data.PeopleToItems;
import com.kfir.inventory_be.data.PersonToItems;
import com.kfir.inventory_be.models.Item;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.repositories.ItemsRepository;
import com.kfir.inventory_be.repositories.PeopleRepository;
import com.kfir.inventory_be.services.ItemsService;
import com.kfir.inventory_be.services.PeopleService;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository repo;

    @Autowired
    private ItemsService itemsService;

    @Override
    public List<Person> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Person> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public Person saveOrUpdatePerson(Person person) {
        return repo.save(person);
    }

    @Override
    public List<Person> saveAll(List<Person> people) {
        return repo.saveAll(people);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public List<Person> getAllByLinkedItemsIsNotNull() {
        return repo.getAllByLinkedItemsIsNotNull();
    }

    public List<Person> getAllBySuggestedItemsIsNotNull() {
        return repo.getAllBySuggestedItemsIsNotNull();
    }

    @Override
    public PeopleToItems findAllPeopleWithLinkedItems() {

        PeopleToItems peopleToItems = new PeopleToItems();

        List<Person> peopleWithItems = getAllByLinkedItemsIsNotNull();

        for (Person person : peopleWithItems) {

            Iterable<Item> personItems = itemsService.findAllById(person.getLinkedItems());

            PersonToItems personToItems = new PersonToItems(person.getId(), personItems);

            peopleToItems.getPeopleToItems().add(personToItems);
        }

        return peopleToItems;
    }

    @Override
    public Person findPersonWithSuggestedItem(UUID itemId){

        List<Person> peopleWithSuggestedItems = getAllBySuggestedItemsIsNotNull();

        if(peopleWithSuggestedItems != null && peopleWithSuggestedItems.size() > 0){
            return peopleWithSuggestedItems.stream().filter(person -> person.getSuggestedItems().contains(itemId)).findFirst().orElse(null);
        }

        return null;
    }

}
