package com.manywho.services.demo.databases;

import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
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
    public Person find(ApplicationConfiguration configuration, ObjectDataType objectDataType, Command command, String id) {
        return repositoryDatabase.find(id);
    }

    @Override
    public List<Person> findAll(ApplicationConfiguration configuration, ObjectDataType objectDataType, Command command, ListFilter filter, List<MObject> objects) {
        return repositoryDatabase.findAll(filter);
    }

    @Override
    public Person create(ApplicationConfiguration configuration, ObjectDataType objectDataType, Person object) {
        return null;
    }

    @Override
    public List<Person> create(ApplicationConfiguration configuration, ObjectDataType objectDataType, List<Person> objects) {
        return null;
    }

    @Override
    public void delete(ApplicationConfiguration configuration, ObjectDataType objectDataType, Person object) {

    }

    @Override
    public void delete(ApplicationConfiguration configuration, ObjectDataType objectDataType, List<Person> objects) {

    }

    @Override
    public Person update(ApplicationConfiguration configuration, ObjectDataType objectDataType, Person person) {
        return repositoryDatabase.update(person);
    }

    @Override
    public List<Person> update(ApplicationConfiguration configuration, ObjectDataType objectDataType, List<Person> objects) {
        return null;
    }
}
