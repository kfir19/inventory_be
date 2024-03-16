package com.kfir.inventory_be.services;

import com.kfir.inventory_be.data.PeopleToItems;
import com.kfir.inventory_be.models.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeopleService {

    List<Person> findAll();

    Optional<Person> findById(UUID id);

    Person saveOrUpdatePerson(Person person);

    List<Person> saveAll(List<Person> people);

    void deleteById(UUID id);

    List<Person> getAllByLinkedItemsIsNotNull();

    PeopleToItems findAllPeopleWithLinkedItems();

    List<Person> getAllBySuggestedItemsIsNotNull();

    Person findPersonWithSuggestedItem(UUID itemId);

    List<Person> getAllByLinkedItemsNotEmpty();

}
