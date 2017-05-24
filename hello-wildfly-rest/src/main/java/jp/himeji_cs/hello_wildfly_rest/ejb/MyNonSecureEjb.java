package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import jp.himeji_cs.hello_wildfly_rest.ejb.MyNonSecureEjbService.MyNonSecureEjbLocal;
import jp.himeji_cs.hello_wildfly_rest.ejb.MyNonSecureEjbService.MyNonSecureEjbRemote;

@Stateless
public class MyNonSecureEjb implements MyNonSecureEjbLocal, MyNonSecureEjbRemote {

    @Resource
    private SessionContext context;

    @Override
    public String getText() {
        return "Hello, PermitAll! " + context.getCallerPrincipal().getName() + ", " + context.isCallerInRole("user");
    }

}
