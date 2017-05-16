package jp.himeji_cs.hello_wildfly_rest.rest;

import io.swagger.annotations.Api;
import java.security.Principal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/logout")
@Produces(MediaType.APPLICATION_JSON)
@Api("ログアウトサービス")
public class LogoutService {

    @Inject
    private HttpServletRequest req;

    @GET
    public boolean logout() {
        try {
            Principal pri = req.getUserPrincipal();
            System.out.println("" + (pri != null ? pri.getName() : "null") + ", " + req.isUserInRole("user"));

            req.logout();

            pri = req.getUserPrincipal();
            System.out.println("" + (pri != null ? pri.getName() : "null") + ", " + req.isUserInRole("user"));

            return true;
        } catch (ServletException e) {
            e.printStackTrace();

            return false;
        }
    }

}
