package com.example.springredisfirst.controller;

import com.example.springredisfirst.model.Person;
import com.example.springredisfirst.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<String> savePerson(@RequestBody Person person){
        boolean result = personService.savePerson(person);
        if(result){
            return ResponseEntity.ok("Person Created");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping
    public ResponseEntity<List<Person>> fetchAllPerson(){
        List<Person> list = personService.fetchAllPerson();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> fetchUserById(@PathVariable Long id){
        Person person = personService.fetchUserById(id);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        boolean result = personService.deletePerson(id);
        if(result){
            return ResponseEntity.ok("Person Deleted Successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
