package com.manywho.services.demo;

import com.manywho.sdk.services.ServiceApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ServiceApplication {
    public Application() {
        try {
            // Register the JDBC driver because Tomcat complains otherwise
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ignored) {

        }

        this.setModule(new ApplicationModule());
        this.initialize();
    }

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.setModule(new ApplicationModule());
        application.startServer("/api/demo/1");
    }
}