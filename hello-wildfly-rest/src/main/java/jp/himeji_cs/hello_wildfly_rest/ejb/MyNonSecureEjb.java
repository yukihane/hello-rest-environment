package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class MyNonSecureEjb implements MyNonSecureEjbLocal {

    @Resource
    private SessionContext context;

    @Override
    public String getText() {
        return "Hello, PermitAll! " + context.getCallerPrincipal().getName() + ", " + context.isCallerInRole("user");
    }

}
