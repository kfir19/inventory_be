package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.repositories.PeopleRepository;
import com.kfir.inventory_be.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository repo;

    @Override
    public List<Person> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Person> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public Person saveOrUpdatePerson(Person person) {
        return repo.save(person);
    }

    @Override
    public List<Person> saveAll(List<Person> people) {
        return repo.saveAll(people);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public List<Person> getAllByLinkedItemsIsNotNull() {
        return repo.getAllByLinkedItemsIsNotNull();
    }
}
