package jp.himeji_cs.hello_wildfly_rest.rest.nested;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/goodby")
@RequestScoped
@Api("goodby")
@Produces(MediaType.APPLICATION_JSON)
public class GoodByResource {

    @GET
    @ApiOperation(value="さよなら")
    public Date goodBy() {
        return new Date();
    }
}
