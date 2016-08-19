package com.manywho.services.demo;

import com.manywho.sdk.services.ServiceApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ServiceApplication {
    public Application() {
        this.setModule(new ApplicationModule());
        this.initialize();
    }

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.setModule(new ApplicationModule());
        application.startServer();
    }
}