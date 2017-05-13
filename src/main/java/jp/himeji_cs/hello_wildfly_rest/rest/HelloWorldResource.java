package jp.himeji_cs.hello_wildfly_rest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    @GET
    public String hello() {
        return "Hello, world!";
    }
}
