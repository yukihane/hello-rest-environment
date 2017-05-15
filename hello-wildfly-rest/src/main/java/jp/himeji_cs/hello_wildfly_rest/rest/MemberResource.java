package jp.himeji_cs.hello_wildfly_rest.rest;

import io.swagger.annotations.Api;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jp.himeji_cs.hello_wildfly_rest.data.MemberRepository;
import jp.himeji_cs.hello_wildfly_rest.model.Member;

@RequestScoped
@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Api
public class MemberResource {

    @Inject
    private MemberRepository rep;

    @GET
    public List<Member> members() {
        return rep.findAllOrderedByName();
    }
}
