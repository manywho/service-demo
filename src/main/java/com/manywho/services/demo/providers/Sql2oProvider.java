package com.manywho.services.demo.providers;

import com.google.inject.Provider;
import org.sql2o.Sql2o;

public class Sql2oProvider implements Provider<Sql2o> {
    @Override
    public Sql2o get() {
        return new Sql2o("jdbc:sqlite::resource:database.sqlite3", null, null);
    }
}
