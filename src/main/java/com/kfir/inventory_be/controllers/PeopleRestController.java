package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.PersonDTO;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.services.PeopleService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleRestController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/")
    public List<PersonDTO> getAllPeople() {
        return ObjectMapperUtils.mapAll(peopleService.findAll(), PersonDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public PersonDTO getPersonById(@PathVariable("id") ObjectId personId) {
        return ObjectMapperUtils.map(peopleService.findPersonById(personId), PersonDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<PersonDTO> saveOrUpdatePerson(@RequestBody PersonDTO personDTO) {
        peopleService.saveOrUpdatePerson(ObjectMapperUtils.map(personDTO, Person.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{personId}")
    public ResponseEntity<PersonDTO> deletePersonById(@PathVariable("personId") ObjectId personId) {
        peopleService.deletePersonById(peopleService.findPersonById(personId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
