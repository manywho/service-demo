package com.manywho.services.demo.databases;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.database.Database;
import com.manywho.services.demo.ApplicationConfiguration;
import com.manywho.services.demo.repositories.PersonRepository;
import com.manywho.services.demo.types.Person;

import javax.inject.Inject;
import java.util.List;

public class PersonDatabase implements Database<ApplicationConfiguration, Person> {
    private final PersonRepository repositoryDatabase;

    @Inject
    public PersonDatabase(PersonRepository repositoryDatabase) {
        this.repositoryDatabase = repositoryDatabase;
    }

    @Override
    public Person create(ApplicationConfiguration configuration, Person person) {
        return null;
    }

    @Override
    public List<Person> create(ApplicationConfiguration configuration, List<Person> list) {
        return null;
    }

    @Override
    public void delete(ApplicationConfiguration configuration, Person person) {

    }

    @Override
    public void delete(ApplicationConfiguration configuration, List<Person> list) {

    }

    @Override
    public Person update(ApplicationConfiguration configuration, Person person) {
        return repositoryDatabase.update(person);
    }

    @Override
    public List<Person> update(ApplicationConfiguration configuration, List<Person> list) {
        return null;
    }

    @Override
    public Person find(ApplicationConfiguration configuration, String id) {
        return repositoryDatabase.find(id);
    }

    @Override
    public List<Person> findAll(ApplicationConfiguration configuration, ListFilter filter) {
        return repositoryDatabase.findAll(filter);
    }
}
