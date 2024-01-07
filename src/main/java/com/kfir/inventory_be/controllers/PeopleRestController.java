package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.data.PeopleToItems;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.models.dto.PersonDTO;
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

    @GetMapping(value = "/getAllPeopleWithLinkedItems")
    public PeopleToItems getAllPeopleWithLinkedItems() {
        return ObjectMapperUtils.map(peopleService.findAllPeopleWithLinkedItems(), PeopleToItems.class);
    }

    @GetMapping(value = "/byId/{id}")
    public PersonDTO getPersonById(@PathVariable("id") UUID personId) {
        return ObjectMapperUtils.map(peopleService.findById(personId), PersonDTO.class);
    }

    @GetMapping(value = "/personWithSuggestedItem/{id}")
    public PersonDTO findPersonWithSuggestedItem(@PathVariable("id") UUID itemId) {
        return ObjectMapperUtils.map(peopleService.findPersonWithSuggestedItem(itemId), PersonDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<PersonDTO> saveOrUpdatePerson(@RequestBody PersonDTO personDTO) {
        try {
            peopleService.saveOrUpdatePerson(ObjectMapperUtils.map(personDTO, Person.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<List<PersonDTO>> saveAll(@RequestBody List<PersonDTO> personDTOs) {
        try {
            peopleService.saveAll(ObjectMapperUtils.mapAll(personDTOs, Person.class));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{personId}")
    public ResponseEntity<PersonDTO> deletePersonById(@PathVariable("personId") UUID personId) {
        try {
            peopleService.deleteById(personId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/byLinkedItemsNotNull")
    public List<PersonDTO> getAllByLinkedItemsNotNull() {
        return ObjectMapperUtils.mapAll(peopleService.getAllByLinkedItemsIsNotNull(), PersonDTO.class);
    }
}
