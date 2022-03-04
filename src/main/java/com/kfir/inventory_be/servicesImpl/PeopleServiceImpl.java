package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.Person;
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
    public Person saveOrUpdatePerson(Person person) {
        return repo.save(person);
    }

    @Override
    public void deletePersonById(ObjectId id) {
        repo.deletePersonById(id);
    }
}
