package com.manywho.services.demo.repositories;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.services.demo.types.Person;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.inject.Inject;
import java.util.List;

public class PersonRepository {
    private final Sql2o sql2o;

    @Inject
    public PersonRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public Person find(String id) {
        String sql = "SELECT * FROM people WHERE id = :id";

        try (Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .addColumnMapping("created_at", "createdAt")
                    .addColumnMapping("social_security_number", "socialSecurityNumber")
                    .executeAndFetchFirst(Person.class);
        }
    }

    public List<Person> findAll(ListFilter filter) {
        String sql = "SELECT * FROM people";

        try (Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addColumnMapping("created_at", "createdAt")
                    .addColumnMapping("social_security_number", "socialSecurityNumber")
                    .executeAndFetch(Person.class);
        }
    }

    public Person update(Person person) {
        String sql = "UPDATE people SET name = :name, biography = :biography, age = :age, active = :active WHERE id = :id";

        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", person.getId())
                    .addParameter("name", person.getName())
                    .addParameter("biography", person.getBiography())
                    .addParameter("age", person.getAge())
                    .addParameter("active", person.isActive())
                    .executeUpdate();
        }

        return person;
    }
}
