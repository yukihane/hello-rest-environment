package jp.himeji_cs.hello_wildfly_rest.rest;

import io.swagger.annotations.Api;
import java.security.Principal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Api("ログインサービス")
public class LoginService {

    @Inject
    private HttpServletRequest req;

    @POST
    public boolean login(LoginData data) {
        try {
            Principal pri = req.getUserPrincipal();
            System.out.println("" + (pri != null ? pri.getName() : "null") + ", " + req.isUserInRole("user"));

            req.login(data.getName(), data.getEmail());

            System.out.println(req.getUserPrincipal().getName() + ", " + req.isUserInRole("user"));

            return true;
        } catch (ServletException e) {
            e.printStackTrace();
            return false;
        }

    }

}
