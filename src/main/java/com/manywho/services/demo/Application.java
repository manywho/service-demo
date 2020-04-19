package com.manywho.services.demo;

import com.manywho.sdk.services.ServiceApplication;
import com.manywho.sdk.services.servers.EmbeddedServer;
import com.manywho.sdk.services.servers.undertow.UndertowServer;

public class Application extends ServiceApplication {
    public static void main(String[] args) throws Exception {
        EmbeddedServer server = new UndertowServer();
        server.setApplication(Application.class);
        server.addModule(new ApplicationModule());
        server.start();
    }
}
