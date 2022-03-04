package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Person;
import org.bson.types.ObjectId;

import java.util.List;

public interface PeopleService {

    List<Person> findAll();

    Person findPersonById(ObjectId id);

    Person saveOrUpdatePerson(Person person);

    void deletePersonById(ObjectId id);
}
