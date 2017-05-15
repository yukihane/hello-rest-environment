package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class MyEjb implements MyEjbLocal {

    @Resource
    private SessionContext context;

    @Override
    public String getText() {
        System.out.println("principal: " + context.getCallerPrincipal().getName());
        return "Hello, EJB! " + context.getCallerPrincipal().getName();
    }

}
