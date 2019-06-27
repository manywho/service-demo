package com.manywho.services.demo;

import com.manywho.sdk.services.servers.EmbeddedServer;
import com.manywho.sdk.services.servers.undertow.UndertowServer;
import com.manywho.sdk.services.servers.Servlet3Server;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/") //that's for running it on Tomcat
public class Application extends Servlet3Server {

    //that's for running it on Tomcat
    public Application() {

        // Register any Guice modules that are needed
        this.addModule(new ApplicationModule());

        // Set the Application class (the entry point to the Service, usually this class)
        this.setApplication(Application.class);

        // Initialize the application
        this.start();
    }

    //that's for running it on Undertow
    public static void main(String[] args) throws Exception {
        EmbeddedServer server = new UndertowServer();
        server.setApplication(Application.class);
        server.addModule(new ApplicationModule());
        server.start("/api/demo/1");
    }
}