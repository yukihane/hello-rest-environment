package jp.himeji_cs.hello_wildfly_rest.ejbclient;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginException;
import jp.himeji_cs.hello_wildfly_rest.ejb.MyEjbService.MyEjbRemote;
import jp.himeji_cs.hello_wildfly_rest.ejb.MyNonSecureEjbService.MyNonSecureEjbRemote;

/**
 * @see https://docs.jboss.org/author/display/WFLY10/EJB+invocations+from+a+remote+client+using+JNDI
 * @see https://github.com/wildfly/quickstart/tree/10.x/ejb-remote/client
 */
public class RemoteEJBClient {

    public static void main(String[] args) throws NamingException, LoginException {
        Context context = createContext();

        MyNonSecureEjbRemote nonSecure = (MyNonSecureEjbRemote) context
            .lookup("ejb:/hello-wildfly-rest//MyNonSecureEjb!" + MyNonSecureEjbRemote.class.getName());

        System.out.println(nonSecure.getText());

        final MyEjbRemote secure =
            (MyEjbRemote) context.lookup("ejb:/hello-wildfly-rest//MyEjb!" + MyEjbRemote.class.getName());

        System.out.println(secure.getText());
    }

    private static Context createContext() throws NamingException {
        final Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        final Context context = new InitialContext(jndiProperties);
        return context;
    }
}
