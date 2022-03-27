package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Person;
import java.util.List;
import java.util.UUID;

public interface PeopleService {

    List<Person> findAll();

    Person findPersonById(UUID id);

    Person saveOrUpdatePerson(Person person);

    void deletePersonById(UUID id);

    List<Person> getAllByLinkedItemsIsNotNull();
}
