
package jp.himeji_cs.hello_wildfly_rest.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jp.himeji_cs.hello_wildfly_rest.ejb.MyEjbService.MyEjbLocal;
import jp.himeji_cs.hello_wildfly_rest.ejb.MyNonSecureEjbService.MyNonSecureEjbLocal;

@Path("/ejb")
@Produces(MediaType.APPLICATION_JSON)
@Api("EJB呼び出しサンプル")
public class EjbCall {

    @EJB
    private MyEjbLocal ejb;

    @EJB
    private MyNonSecureEjbLocal nonSecure;

    @GET
    @Path("/secure")
    @ApiOperation("ejbを使用したメソッドコール")
    public String get() {
        return ejb.getText();
    }

    @GET
    @Path("/nonsecure")
    @ApiOperation("認証不要EJBメソッドコール")
    public String nonSecure() {
        return nonSecure.getText();
    }
}
