package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.models.Role;
import com.kfir.inventory_be.repositories.PeopleRepository;
import com.kfir.inventory_be.services.PeopleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository repo;

    @Override
    public List<Person> findAll() {
        return repo.findAll();
    }

    @Override
    public Person findPersonById(ObjectId id) {
        return repo.findPersonById(id);
    }

    @Override
    public List<Person> findPeopleByFirstName(String firstName) {
        return repo.findPeopleByFirstName(firstName);
    }

    @Override
    public List<Person> findPeopleByLastName(String lastName) {
        return repo.findPeopleByLastName(lastName);
    }

    @Override
    public List<Person> findPeopleByFirstNameAndLastName(String firstName, String lastName) {
        return repo.findPeopleByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {
        return repo.findPersonByPhoneNumber(phoneNumber);
    }

    @Override
    public Person findPersonByPersonalNumber(String personalNumber) {
        return repo.findPersonByPersonalNumber(personalNumber);
    }

    @Override
    public List<Person> findPeopleByRole(Role kind) {
        return repo.findPeopleByRole(kind);
    }

    @Override
    public List<Person> findPeopleByLinkedItems(List<ObjectId> itemIds) {
        return repo.findPeopleByLinkedItems(itemIds);
    }

    @Override
    public Person saveOrUpdatePerson(Person person) {
        return repo.save(person);
    }

    @Override
    public void deletePersonById(ObjectId id) {
        repo.deletePersonById(id);
    }
}
