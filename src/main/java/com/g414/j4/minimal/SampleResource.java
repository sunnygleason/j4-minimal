package com.g414.j4.minimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * The Jersey Resource itself. Note that this class is a POJO - it does not need
 * to know anything about Guice. Although, if we wanted to Inject members using
 * Guice, we could!
 */
@Path("/sample")
public class SampleResource {
    @GET
    @Produces("text/plain")
    @Path("{who}")
    public String sayGreeting(@PathParam("who") String name) {
        return "Greetings, " + name + "!";
    }
}
