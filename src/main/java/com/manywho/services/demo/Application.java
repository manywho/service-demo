package com.manywho.services.demo;

import com.google.inject.AbstractModule;
import com.manywho.sdk.services.ServiceApplication;
import com.manywho.services.demo.providers.Sql2oProvider;
import org.sql2o.Sql2o;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ServiceApplication {
    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.setModule(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Sql2o.class).toProvider(Sql2oProvider.class);
            }
        });
        application.startServer();
    }
}