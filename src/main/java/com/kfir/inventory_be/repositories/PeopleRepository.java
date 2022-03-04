package com.kfir.inventory_be.repositories;

import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.models.Role;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PeopleRepository extends MongoRepository<Person, ObjectId> {

    List<Person> findAll();

    Person findPersonById(ObjectId id);

    List<Person> findPeopleByFirstName(String firstName);

    List<Person> findPeopleByLastName(String lastName);

    List<Person> findPeopleByFirstNameAndLastName(String firstName, String lastName);

    Person findPersonByPhoneNumber(String phoneNumber);

    Person findPersonByPersonalNumber(String personalNumber);

    List<Person> findPeopleByRole(Role kind);

    List<Person> findPeopleByLinkedItems(List<ObjectId> itemIds);

    Person save(Person person);

    void deletePersonById(ObjectId id);


}
