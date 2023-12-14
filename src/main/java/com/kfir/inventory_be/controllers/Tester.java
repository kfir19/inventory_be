package com.kfir.inventory_be.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tester")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class Tester {

    @GetMapping(value = "/")
    public String test() {
        return "Tester was called successfully";
    }

}
