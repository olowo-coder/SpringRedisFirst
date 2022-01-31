package com.example.springredisfirst.repository;

import com.example.springredisfirst.model.Person;

import java.util.List;

public interface PersonDao {
    boolean savePerson(Person person);

    List<Person> fetchAllUser();

    Person fetchPersonById(Long id);

    boolean deletePerson(Long id);
}
