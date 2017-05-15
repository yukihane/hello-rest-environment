package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import jp.himeji_cs.hello_wildfly_rest.model.Member;
import jp.himeji_cs.hello_wildfly_rest.service.MemberRegistration;

@Singleton
@javax.ejb.Startup
public class Startup {

    @EJB
    private MemberRegistration regist;

    @PostConstruct
    public void postConstruct() throws Exception {
        Member member = new Member();
        member.setName("sampleuser");
        member.setEmail("sampleuser@example.com");
        member.setPhoneNumber("0123456789");
        regist.register(member);
    }

}
