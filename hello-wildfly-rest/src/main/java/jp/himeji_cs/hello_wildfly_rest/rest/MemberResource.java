package jp.himeji_cs.hello_wildfly_rest.rest;

import io.swagger.annotations.Api;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jp.himeji_cs.hello_wildfly_rest.data.MemberRepository;
import jp.himeji_cs.hello_wildfly_rest.model.Member;
import jp.himeji_cs.hello_wildfly_rest.service.MemberRegistration;

@RequestScoped
@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Api
public class MemberResource {

    @Inject
    private MemberRegistration regist;

    @Inject
    private MemberRepository rep;

    @Inject
    private HttpServletRequest request;

    @POST
    @Path("/init")
    public boolean init() {
        Member member = new Member();
        member.setName("yukihane");
        member.setEmail("yukihane@example.com");
        member.setPhoneNumber("0123456789");
        try {
            regist.register(member);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GET
    public List<Member> members() {
        return rep.findAllOrderedByName();
    }

    @POST
    @Path("/login")
    public boolean login(LoginData data) {

        try {
            request.login(data.getName(), data.getEmail());
            System.out.println(request.getUserPrincipal());
            return true;
        } catch (ServletException e) {
            e.printStackTrace();
            return false;
        }

    }
}
