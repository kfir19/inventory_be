package com.kfir.inventory_be.services;

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

    List<Person> getAllByLinkedKitsIsNotNull();

    List<Person> getAllByLinkedItemsIsNotNullOrLinkedKitsIsNotNull();
}
