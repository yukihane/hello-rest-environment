package jp.himeji_cs.hello_wildfly_rest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Api("ハローワールドAPI")
public class HelloWorldResource {

    @GET
    @Path("/{name}")
    @ApiOperation("名前付きwelcomeメッセージを出力します")
    public String hello(@ApiParam("名前") @PathParam("name") String name) {
        return "Hello, " + name;
    }
}
