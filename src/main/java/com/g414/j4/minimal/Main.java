package com.g414.j4.minimal;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;

import com.google.inject.servlet.GuiceFilter;

/**
 * Starts an embedded Jetty server.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        Context root = new Context(server, "/", Context.SESSIONS);

        root.addEventListener(new SampleConfig());
        root.addFilter(GuiceFilter.class, "/*", 0);

        root.addServlet(EmptyServlet.class, "/*");

        server.start();
    }
}
