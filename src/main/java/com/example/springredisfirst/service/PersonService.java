package com.example.springredisfirst.service;

import com.example.springredisfirst.model.Person;

import java.util.List;

public interface PersonService {
    boolean savePerson(Person person);

    List<Person> fetchAllPerson();

    Person fetchUserById(Long id);

    boolean deletePerson(Long id);
}
