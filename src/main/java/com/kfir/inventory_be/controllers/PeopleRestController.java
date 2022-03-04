package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.PersonDTO;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.models.Role;
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

    @GetMapping(value = "/byFirstName/{firstName}")
    public List<PersonDTO> getPeopleByFirstName(@PathVariable("firstName") String firstName) {
        return ObjectMapperUtils.mapAll(peopleService.findPeopleByFirstName(firstName), PersonDTO.class);
    }

    @GetMapping(value = "/byLastName/{lastName}")
    public List<PersonDTO> getPeopleByLastName(@PathVariable("lastName") String lastName) {
        return ObjectMapperUtils.mapAll(peopleService.findPeopleByLastName(lastName), PersonDTO.class);
    }

    @GetMapping(value = "/byFirstNameAndLastName/{firstName}/{lastName}")
    public List<PersonDTO> getPeopleByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return ObjectMapperUtils.mapAll(peopleService.findPeopleByFirstNameAndLastName(firstName, lastName), PersonDTO.class);
    }

    @GetMapping(value = "/byPhoneNumber/{phoneNumber}")
    public PersonDTO getPersonByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return ObjectMapperUtils.map(peopleService.findPersonByPhoneNumber(phoneNumber), PersonDTO.class);
    }

    @GetMapping(value = "/byPersonalNumber/{personalNumber}")
    public PersonDTO getPersonByPersonalNumber(@PathVariable("personalNumber") String personalNumber) {
        return ObjectMapperUtils.map(peopleService.findPersonByPersonalNumber(personalNumber), PersonDTO.class);
    }

    @GetMapping(value = "/byRole/{kind}")
    public List<PersonDTO> getPeopleByRole(@PathVariable("kind") Role kind) {
        return ObjectMapperUtils.mapAll(peopleService.findPeopleByRole(kind), PersonDTO.class);
    }

    @GetMapping(value = "/byLinkedItems/{itemIds}")
    public List<PersonDTO> getPeopleByLinkedItems(@PathVariable("itemIds") List<ObjectId> itemIds) {
        return ObjectMapperUtils.mapAll(peopleService.findPeopleByLinkedItems(itemIds), PersonDTO.class);
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
