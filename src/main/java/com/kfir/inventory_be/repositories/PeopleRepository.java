package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.UUID;

public interface PeopleRepository extends MongoRepository<Person, UUID> {

    List<Person> findAll();

    Person findPersonById(UUID id);

    Person save(Person person);

    void deletePersonById(UUID id);


}
