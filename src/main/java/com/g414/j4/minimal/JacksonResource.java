package com.g414.j4.minimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Jersey Jackson Resource itself. Note that this class is a POJO - it does
 * not need to know anything about Guice. Although, if we wanted to Inject
 * members using Guice, we could!
 */
@Path("/jackson")
public class JacksonResource {
    @GET
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("{who}")
    public Greeting sayGreeting(@PathParam("who") String name) {
        return new Greeting(name);
    }

    /**
     * A static inner class result object; it's only "static inner" for
     * simplicity - really, this could be any POJO bean that you desire.
     */
    @XmlRootElement
    public static class Greeting {
        private String name;

        public Greeting() {
        }

        public Greeting(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
