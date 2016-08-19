package com.manywho.services.demo;

import com.google.inject.AbstractModule;
import com.manywho.services.demo.providers.Sql2oProvider;
import org.sql2o.Sql2o;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Sql2o.class).toProvider(Sql2oProvider.class);
    }
}
