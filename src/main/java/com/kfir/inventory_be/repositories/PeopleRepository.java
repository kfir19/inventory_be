package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PeopleRepository extends MongoRepository<Person, ObjectId> {

    List<Person> findAll();

    Person findPersonById(ObjectId id);

    Person save(Person person);

    void deletePersonById(ObjectId id);


}
