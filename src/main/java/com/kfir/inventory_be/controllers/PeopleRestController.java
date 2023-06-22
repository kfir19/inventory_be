package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.models.dto.PersonDTO;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.services.PeopleService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class PeopleRestController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/")
    public List<PersonDTO> getAllPeople() {
        return ObjectMapperUtils.mapAll(peopleService.findAll(), PersonDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public PersonDTO getPersonById(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.map(peopleService.findById(personId), PersonDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<PersonDTO> saveOrUpdatePerson(@RequestBody PersonDTO personDTO) {
        peopleService.saveOrUpdatePerson(ObjectMapperUtils.map(personDTO, Person.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{personId}")
    public ResponseEntity<PersonDTO> deletePersonById(@PathVariable("personId") UUID personId) {
        if((peopleService.findById(personId)).isPresent()) {
            peopleService.deleteById((peopleService.findById(personId)).get().getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/byLinkedItemsNotNull")
    public List<PersonDTO> getAllByLinkedItemsNotNull() {
        return ObjectMapperUtils.mapAll(peopleService.getAllByLinkedItemsIsNotNull(), PersonDTO.class);
    }

    @GetMapping(value = "/byLinkedKitsNotNull")
    public List<PersonDTO> getAllByLinkedKitsNotNull() {
        return ObjectMapperUtils.mapAll(peopleService.getAllByLinkedKitsIsNotNull(), PersonDTO.class);
    }

    @GetMapping(value = "/byLinkedKitsOrItemsNotNull")
    public List<PersonDTO> getAllByLinkedKitsOrItemsNull() {
        return ObjectMapperUtils.mapAll(peopleService.getAllByLinkedItemsIsNotNullOrLinkedKitsIsNotNull(), PersonDTO.class);
    }
}
