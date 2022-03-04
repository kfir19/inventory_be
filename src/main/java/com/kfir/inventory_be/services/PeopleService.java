package com.kfir.inventory_be.services;

import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.models.Role;
import org.bson.types.ObjectId;

import java.util.List;

public interface PeopleService {

    List<Person> findAll();

    Person findPersonById(ObjectId id);

    List<Person> findPeopleByFirstName(String firstName);

    List<Person> findPeopleByLastName(String lastName);

    List<Person> findPeopleByFirstNameAndLastName(String firstName, String lastName);

    Person findPersonByPhoneNumber(String phoneNumber);

    Person findPersonByPersonalNumber(String personalNumber);

    List<Person> findPeopleByRole(Role kind);

    List<Person> findPeopleByLinkedItems(List<ObjectId> itemIds);

    Person saveOrUpdatePerson(Person person);

    void deletePersonById(ObjectId id);
}
