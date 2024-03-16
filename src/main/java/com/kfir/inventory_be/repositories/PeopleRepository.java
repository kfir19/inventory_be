package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.data.PeopleToItems;
import com.kfir.inventory_be.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeopleRepository extends MongoRepository<Person, UUID> {

    List<Person> findAll();

    Optional<Person> findById(UUID id);

    Person save(Person person);

    @Override
    <S extends Person> List<S> saveAll(Iterable<S> entities);

    void deleteById(UUID id);

    List<Person> getAllByLinkedItemsNotEmpty();

    List<Person> getAllByLinkedItemsIsNotNull();

    List<Person> getAllBySuggestedItemsIsNotNull();
}

